package nio.p6_mapped_files;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MappedIO {

    private static int numOfInts = 4_000_000;
    private static int numOfUbuffInts = 200_000;

    private abstract static class Tester {
        private String name;
        Tester(String name) { this.name = name; }
        void runTest() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration/1.0e9);
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
        public abstract void test() throws IOException;
    }

    private static Tester[] tests = {
            new Tester("Stream Write") {
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(new File("temp.tmp"))));
                    for(int i = 0; i < numOfInts; i++)
                        dos.writeInt(i);
                    dos.close();
                }
            },
            new Tester("Mapped Write") {
                public void test() throws IOException {
                    FileChannel fc =
                            new RandomAccessFile("temp.tmp", "rw")
                                    .getChannel();
                    IntBuffer ib = fc.map(
                            FileChannel.MapMode.READ_WRITE, 0, fc.size())
                            .asIntBuffer();
                    for(int i = 0; i < numOfInts; i++)
                        ib.put(i);
                    fc.close();
                    ib = null; // todo: check it...
                }
            },
            new Tester("Stream Read") {
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("temp.tmp")));
                    for(int i = 0; i < numOfInts; i++)
                        dis.readInt();
                    dis.close();
                }
            },
            new Tester("Mapped Read") {
                public void test() throws IOException {
                    FileChannel fc = new FileInputStream(
                            new File("temp.tmp")).getChannel();
                    IntBuffer ib = fc.map(
                            FileChannel.MapMode.READ_ONLY, 0, fc.size())
                            .asIntBuffer();
                    while(ib.hasRemaining())
                        ib.get();
                    fc.close();
                    ib = null;
                }
            },
            new Tester("Stream Read/Write") {
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(
                            new File("temp.tmp"), "rw");
                    raf.writeInt(1);
                    for(int i = 0; i < numOfUbuffInts; i++) {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped Read/Write") {
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(
                            new File("temp.tmp"), "rw").getChannel();
                    IntBuffer ib = fc.map(
                            FileChannel.MapMode.READ_WRITE, 0, fc.size())
                            .asIntBuffer();
                    ib.put(0);
                    for(int i = 1; i < numOfUbuffInts; i++)
                        ib.put(ib.get(i - 1));
                    fc.close();
                    ib = null;
                }
            }
    };

    public static void main(String[] args) {
        for(Tester test : tests){
            test.runTest();
            System.gc(); //todo: note that it is needed to delete the file below...
        }

        Path path = Paths.get("temp.tmp");
        if(Files.exists(path)){
            System.out.println("file exists...");
            System.out.println("... deleting it...");

            System.gc();
            try {
                Files.delete(path);
            } catch (Exception ex){
                System.err.println("gor exception: " + ex);
            }
        } else {
            System.out.println("file does not exist...");
        }

    }
}

/* Output: (90% match)
Stream Write: 0.56
Mapped Write: 0._12
Stream Read: 0.80
Mapped Read: 0._07
Stream Read/Write: 5.32
Mapped Read/Write: 0._02
*/
