package nio.p2_buffers;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO: note - file data2.txt had been written before (in the Sample_5_...)
 */

public class Sample_6_Write_Read {

    public static void main(String[] args) throws Exception {
        write();
        read();
    }

    public static void write() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("data2.txt", "rw");
        FileChannel outChannel = aFile.getChannel();
        String newData = "New String to write: " + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48); //todo: show with 48, then change to 12 and show again...
//        ByteBuffer buf = ByteBuffer.allocate(12); //todo: and fix the error ...
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();

        while (buf.hasRemaining()){
            outChannel.write(buf);
        }
        aFile.close();
    }

    public static void read() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("data2.txt", "rw");
        System.out.println("file length = " + aFile.length());
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48); //todo: show with 48, then change to 12 and show again...
//        ByteBuffer buf = ByteBuffer.allocate(12);

        int bytesRead = inChannel.read(buf); //channel reads into buffer (initially).
        while (bytesRead != -1) {
            buf.flip(); //make buffer ready for read
            while(buf.hasRemaining()) {
                System.out.print((char) buf.get()); // read 1 byte at a time
            }
            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf); // channel reads into buffer (again)…
        }
        aFile.close();
    }

}
