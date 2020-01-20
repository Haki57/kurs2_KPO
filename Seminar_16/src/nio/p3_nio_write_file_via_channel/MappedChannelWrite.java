package nio.p3_nio_write_file_via_channel;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class MappedChannelWrite {
    public static void main(String args[]) throws IOException {
// Obtain a channel to a file within a try-with-resources block.
        try ( FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ,
                        StandardOpenOption.CREATE) ) {
// Then, map the file into a buffer.
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
// Write some bytes to the buffer.
            for(int i = 0; i < 26; i++)
                mBuf.put((byte)('A' + i));

            mBuf = null; //TODO: note that having these lines commented out we do not delete the file test.txt...
            System.gc();

        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }

        Path path = Paths.get("test.txt");
        Files.delete(path);
    }
}
