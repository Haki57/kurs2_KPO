package p4_client_server.example_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO: This sample is to illustrate Duplex nature of the connection ...
 * TODO: it is always recommended to close Socket objects at both sides after their use.
 * TODO: before the server program terminates, the ServerSocket object should be closed.
 */

public class ConnectionServer {
    public static void main(String[] args) {
        String message = "Hello from server";
        int serverPortNimber = 3456;

        try {
            ServerSocket connectionSocket = new ServerSocket(serverPortNimber);
            System.out.println("calling accept()...");
            Socket dataSocket = connectionSocket.accept();
            System.out.println("accept() performed: dataSocket = " + dataSocket);

            PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream());
            socketOutput.println(message);
            System.out.println("response to client sent...");
            socketOutput.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
            System.out.println("message from client: " + br.readLine());

            dataSocket.close();
            connectionSocket.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
