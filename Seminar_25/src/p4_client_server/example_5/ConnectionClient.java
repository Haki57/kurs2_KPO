package p4_client_server.example_5;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * TODO: modify this sample to get ints from user dialog, send them to the server to get the result and show it for the user
 */
public class ConnectionClient {
    public static void main(String[] args) {
        String serverHostName = "localhost";
        int serverPortNumber = 3456;

        try {
            if (args.length > 1){
                serverHostName = args[0];
                serverPortNumber = Integer.parseInt(args[1]);
            }

            InetAddress serverHost = InetAddress.getByName(serverHostName);
            Socket clientSocket = new Socket(serverHost, serverPortNumber);

            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            ps.println(2);
            ps.flush();
            ps.println(3);
            ps.flush();

            clientSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
