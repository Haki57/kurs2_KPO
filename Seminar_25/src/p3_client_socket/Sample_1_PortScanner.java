package p3_client_socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
/*
    TODO: simple check for TCP-server listening on a given ports from 1 to 1024
    it takes a long time to check...
    Try start your own server and check if it is waiting for connections (but don't use reserved ports)...
 */

public class Sample_1_PortScanner {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
//        String host = args.length > 0 ? args[0] : "hse.ru";
        for (int i = 1; i < 1024; i++) {
            System.out.print("i = " + i); // just to see that something is going on...
            try {
                Socket socket = new Socket(host, i);
                System.out.println(": There is a TCP-server on port " + i + " of " + host);
                socket.close();
            } catch (UnknownHostException uhex) {
                System.err.println("got exception: " + uhex);
                break;
            } catch (IOException ioex) {
                // no TCP-server on this port...
                System.out.println(": No TCP-server in this port");
            }
        }
    }
}
