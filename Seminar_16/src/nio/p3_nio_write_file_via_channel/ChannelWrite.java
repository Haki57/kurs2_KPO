package nio.p3_nio_write_file_via_channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class ChannelWrite {
    public static void main(String args[]) throws IOException {
// Obtain a channel to a file within a try-with-resources block.
        try ( FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE) ) {
// Create a buffer.
            ByteBuffer mBuf = ByteBuffer.allocate(26);

//----------------------------------------------------------------------------------------------------------------------
//// Write some bytes to the buffer.
//            for(int i = 0; i < 26; i++)
//                mBuf.put((byte)('A' + i));
//// Reset the buffer so that it can be written.
//            mBuf.rewind();
//// Write the buffer to the output file.
//            fChan.write(mBuf);
//----------------------------------------------------------------------------------------------------------------------
            for(int h = 0; h < 3; h++) {
// Write some bytes to the buffer.
                for(int i = 0; i < 26; i++)
                    mBuf.put((byte)('A' + i));
// Rewind the buffer so that it can be written.
                mBuf.rewind(); //TODO: note that rewind switches the buffer for another operation...
// Write the buffer to the output file.
                fChan.write(mBuf);
// Rewind the buffer so that it can be written to again.
                mBuf.rewind();
            }
//----------------------------------------------------------------------------------------------------------------------
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
            System.exit(1);
        }

        Path path = Paths.get("test.txt");
        Files.delete(path);
    }
}
