package nio.p5_nio_stream_based_io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NioStreamRead {
    public static void main(String args[]) {
// Open the file and obtain a stream linked to it.
        try ( InputStream fin = Files.newInputStream(Paths.get("test.txt")) ) {
            int i;
            do {
                i = fin.read();
                if(i != -1)
                    System.out.print((char) i);
            } while(i != -1);
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch(IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
