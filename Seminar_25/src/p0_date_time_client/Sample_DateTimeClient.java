package p0_date_time_client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 *  try in command prompt window: telnet time.nist.gov 13
 *  or telnet time-a.nist.gov 13
 *  or enter telnet and open time-a.nist.gov 13
 *
 *  https://tf.nist.gov/tf-cgi/servers.cgi - see explanations about time.nist.gov servers...
 */
public class Sample_DateTimeClient {
    public static void main(String[] args) throws UnknownHostException {
//        String hostname = "time.nist.gov";
        String hostname = "time-a.nist.gov";
        InetAddress inetAddress = InetAddress.getByName(hostname);
 System.out.println("inetAddress: " + inetAddress);

        try (Socket socket = new Socket(hostname, 13)) {
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        // ignore
    }
}
