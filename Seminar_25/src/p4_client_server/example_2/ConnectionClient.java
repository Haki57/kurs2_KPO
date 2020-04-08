package p4_client_server.example_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * TODO: start the server first...
 */

public class ConnectionClient {
    public static void main(String[] args) {
        String serverHostName = args.length > 0 ? args[0] : "localhost";
        int serverPortNumber = 3456;

        try {
            InetAddress serverHost = InetAddress.getByName(serverHostName);
            System.out.println("creating clientSocket...");
            Socket clientSocket = new Socket(serverHost, serverPortNumber);
            System.out.println("clientSocket created...");

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("message from server: " + br.readLine());

            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            ps.println("received your message... Thanks");
            ps.flush();

            clientSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
