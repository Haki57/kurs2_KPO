package p4_client_server.example_3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO: This example server can be communicating with any of the previous clients...Try to use both of them...
 */
public class ConnectionServer {
    public static void main(String[] args) {
        String message = "Welcome to the Java Networking World !!!";
        int serverPortNimber = 3456;

        try {
            if (args.length > 1) {
                message = args[0];
                serverPortNimber = Integer.parseInt(args[1]);
            }

            ServerSocket connectionSocket = new ServerSocket(serverPortNimber);

            while (true) {
System.out.println("calling accept()...");
                Socket dataSocket = connectionSocket.accept();
System.out.println("accept() performed: dataSocket = " + dataSocket);

                PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream());
                socketOutput.println(message);
System.out.println("response to client sent...");

                socketOutput.flush();
                dataSocket.close();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
