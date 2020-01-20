package nio.p7_asynchronous_fileChannels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsynchronousFileChannel_2_callback {

    public static void main(String[] args) {
        System.out.println("thread = " + Thread.currentThread());
        Path path = Paths.get("testData.txt");
        try {
            Files.createFile(path);
            write2(path);
            read2(path);
        } catch (Exception ex){
            System.err.println("got exception: " + ex);
        } finally {
//            try {
//                Files.delete(path);
//            } catch (IOException ioe){
//                //
//            }
        }
    }

    private static void write2(Path path) throws IOException {
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
        buffer.put("test data specifically created for this demo purposes...".getBytes());
        buffer.flip();
        fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            private long t0; // = System.nanoTime();
            {
                System.out.println("init completion handler...");
                t0 = System.nanoTime();
            }
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(Thread.currentThread() + " -> time elapsed: " + (System.nanoTime() - t0));
                System.out.println("bytes written: " + result);
        }
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed"); exc.printStackTrace();
            }
        }); // не жужжим – результат узнаем через callback…

        System.out.println(Thread.currentThread() + ": write2() performed.");
    }

    private static void read2(Path path) throws IOException {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            private long t0; // = System.nanoTime();
            {
                System.out.println("init completion handler...");
                t0 = System.nanoTime();
            }
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(Thread.currentThread() + " -> time elapsed = " + (System.nanoTime() - t0));
                System.out.println("result = " + result);
                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) { }
        });
//        System.out.println("read2() performed.");
        System.out.println(Thread.currentThread() + ": read2() performed.");
    }
}
