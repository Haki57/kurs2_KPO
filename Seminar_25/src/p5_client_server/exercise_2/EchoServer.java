package p5_client_server.exercise_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO: note - this server cannot serve multiple clients, it invites the only client first and finishes after one interaction.
 */

public class EchoServer extends Thread {
    // This class implements server sockets. A server socket waits for requests to come
    // in over the network only when it is allowed through the local firewall
    private ServerSocket serverSocket;

    private EchoServer(int port, int timeout){
        try {
            // Create a new Server on specified port.
            serverSocket = new ServerSocket(port);
            // SoTimeout is basiacally the socket timeout.
            // timeout is the time until socket timeout in milliseconds
            serverSocket.setSoTimeout(timeout);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run(){
        try {
            // We want the server to continuously accept connections (we do not accept multiple clients...)
            while(!Thread.interrupted()){
                try {
                    // Log with the port number and machine ip
                    Logger.getLogger((getClass().getName())).log(Level.INFO, "Listening for Clients at {0} on {1}",
                            new Object[]{serverSocket.getLocalPort(), InetAddress.getLocalHost().getHostAddress()});
                    Socket client = serverSocket.accept(); // Accept client connection...
                    // Now get DataInputStream and DataOutputStreams
                    DataInputStream istream = new DataInputStream(client.getInputStream()); // From client's input stream
                    DataOutputStream ostream = new DataOutputStream(client.getOutputStream());
                    // Important Note
                    /*
                    The server's input is the client's output
                    The client's input is the server's output
                    */
                    // Send a welcome message
                    ostream.writeUTF("Welcome!");
                    String inString = istream.readUTF(); // Read what the user sent
                    String outString = inString.toUpperCase(); // Change it to caps
                    ostream.writeUTF(outString);
                    // Close the connection
                    istream.close();
                    ostream.close();
                    client.close();
                } catch (IOException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Close the server once done.
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
//        new EchoServer(3456, 1000).run(); // 0 - means no timeout...
        new EchoServer(3456, 0).run(); // 0 - means no timeout...
    }

}
