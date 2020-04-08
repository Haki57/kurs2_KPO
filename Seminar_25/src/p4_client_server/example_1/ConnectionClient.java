package p4_client_server.example_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * TODO: first start ConnectionServer then ConnectionClient...
 * TODO: see the outputs in the consoles (for server and for client)
 */
public class ConnectionClient {
    public static void main(String[] args) {
        String serverHostName = "localhost";
        int serverPortNumber = 3456;

         try {
            InetAddress serverHost = InetAddress.getByName(serverHostName);
System.out.println("creating clientSocket...");
            Socket clientSocket = new Socket(serverHost, serverPortNumber);
System.out.println("clientSocket created...");

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(br.readLine());

            clientSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
