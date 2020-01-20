package nio.p2_buffers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Sample_5_BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fileChannel = new FileOutputStream("data2.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text ".getBytes()));
        fileChannel.close();

        fileChannel = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fileChannel.read(buffer);
        buffer.flip();

        System.out.println(buffer.asCharBuffer()); // it does not work!!!
        // decoding using default encoding:
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("decoded in " + encoding + ": " + Charset.forName(encoding).decode(buffer));

        //encoding in printable form:
        fileChannel = new FileOutputStream("data2.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fileChannel.close();

        // try to read again:
        fileChannel = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fileChannel.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        //using CharBuffer for writing:
        fileChannel = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(24); // more than needed...
        buffer.asCharBuffer().put("Some text");
        fileChannel.write(buffer);
        fileChannel.close();
        // read and output:
        fileChannel = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fileChannel.read(buffer);
        buffer.flip();
        fileChannel.close();
        System.out.println(buffer.asCharBuffer());
    }
}
