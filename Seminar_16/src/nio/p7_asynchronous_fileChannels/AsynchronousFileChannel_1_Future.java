package nio.p7_asynchronous_fileChannels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannel_1_Future {

    public static void main(String[] args) {
        Path path = Paths.get("testData.txt");
        try {
            Files.createFile(path);
            write1(path);
            read1(path);
        } catch (Exception ex){
            System.err.println("got exception: " + ex);
        } finally {
            try {
                Files.delete(path);
            } catch (IOException ioe){
                //
            }
        }
    }

    private static void write1(Path path) throws Exception {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
//        buffer.put("test data, specifically created for testing purposes...".getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 350; i++){
            sb.append(i);
        }
        buffer.put(sb.toString().getBytes());

        buffer.flip();
        Future<Integer> operation = fileChannel.write(buffer, position);
//        buffer.clear();
        long t0 = System.nanoTime();
        while (!operation.isDone()){
        }; // do nothing but this check...
        long t1 = System.nanoTime();
        System.out.println("t1 - t0 = " + (t1 - t0));
        System.out.println("Write done");
    }

    private static void read1(Path path) throws Exception {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
        Future<Integer> operation = fileChannel.read(buffer, position);
        long t0 = System.nanoTime();
        while (!operation.isDone()){
        }; // do nothing but this check...
        long t1 = System.nanoTime();
System.out.println("t1 - t0 = " + (t1 - t0));
        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
//        buffer.clear();
    }
}
