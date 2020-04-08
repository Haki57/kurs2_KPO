package p4_client_server.example_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO: modify the example to implement client-server calculator that operates with ints and +,-,/,* and returns results to clients...
 *
 */

public class ConnectionServer {
    public static void main(String[] args) {
        int serverPortNimber = 3456;

        try {
            if (args.length > 0) {
                serverPortNimber = Integer.parseInt(args[0]);
            }
            ServerSocket connectionSocket = new ServerSocket(serverPortNimber);
            Socket dataSocket = connectionSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());

            System.out.println( n1 + " + " + n2 + " = " + (n1 + n2));

            dataSocket.close();
            connectionSocket.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
