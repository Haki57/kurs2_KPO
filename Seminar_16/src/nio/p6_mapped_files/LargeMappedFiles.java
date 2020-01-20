package nio.p6_mapped_files;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

// Creating a very large file using mapping.
// TODO: see test.dat file in the File System having this program performed...(and delete it !!!)

public class LargeMappedFiles {

    private static int length = 0x8FFFFFF; // > 128 MB

    public static void main(String[] args) throws Exception {

        File file = new File("test.dat");
        RandomAccessFile aFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = aFile.getChannel();
        MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, length);

        for(int i = 0; i < length; i++)
            out.put((byte)'x');
        System.out.println("Finished writing");

        for(int i = length/2; i < length/2 + 6; i++)
            System.out.print((char)out.get(i));
        System.out.println();

        out = null;  //todo - we have to free our buffer - otherwise a file cannot be deleted !
        System.gc(); //todo - find the answer: why we need to call gc here, if its' actions are not guaranteed?

        fileChannel.close();
        aFile.close();

        long fileLength = file.length();
        System.out.println("file.length = " + fileLength + "; hexString = " + Long.toHexString(fileLength));

        //todo: delete the file automatically...
        if (file.exists()){
            if (file.delete()){
                System.out.println("file " + file + " deleted");
            }
            else
            {
                System.out.println("Cannot delete file: " + file);
                Files.delete(file.toPath());
            }
        }
//        file.deleteOnExit(); //todo: or just use that trick...but it does not delete the file as well without gc...
    }
}

