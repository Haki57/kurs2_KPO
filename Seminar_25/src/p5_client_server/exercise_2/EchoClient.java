package p5_client_server.exercise_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO: note - this client wait for the server message first, and it quits after one interaction with the server.
 */

public class EchoClient extends Thread {

    private Socket server;
    private Scanner scanner; // Scanner for input

    public EchoClient(String ip, int port){
        try {
            server = new Socket(ip, port);
            scanner = new Scanner(System.in);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run(){
        DataInputStream istream = null;
        DataOutputStream ostream = null;
        try {
            istream = new DataInputStream(server.getInputStream()); // Familiar lines
            ostream = new DataOutputStream(server.getOutputStream());
            System.out.println(istream.readUTF()); // Print what the server sends
            System.out.print(">");
            String tosend = scanner.nextLine();
            ostream.writeUTF(tosend); // Send whatever the user typed to the server
            System.out.println(istream.readUTF()); // Finally read what the server sends beforeexiting.
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                istream.close();
                ostream.close();
                server.close();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new EchoClient("localhost", 3456).run();
    }
}
