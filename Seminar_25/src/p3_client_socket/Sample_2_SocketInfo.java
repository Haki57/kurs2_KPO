package p3_client_socket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * TODO run with args: www.oreilly.com www.oreilly.com (see that local ports on my PC are different...)
 *  or www.hse.ru www.hse.ru www.hse.ru www.hse.ru ...
 *  See how local ports are allocated...()
 */
public class Sample_2_SocketInfo {
    public static void main(String[] args) {
        for (String host : args) {
            try {
                Socket socket = new Socket(host, 80);
                System.out.println("Connected to " + socket.getInetAddress() + " on port " + socket.getPort()
                        + " from port " + socket.getLocalPort() + " of " + socket.getLocalAddress()
                );
                socket.close();
            } catch (UnknownHostException unkhex) {
                System.err.println("Cannot find host: " + host);
            } catch (SocketException soex) {
                System.err.println("Cannot connect to : " + host);
            } catch (IOException ioex) {
                System.err.println("got exception: " + ioex);
            }
        }
    }
}
