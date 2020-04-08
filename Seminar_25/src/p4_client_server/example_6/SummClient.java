package p4_client_server.example_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * TODO: run with args: 100
 * TODO: first start it after starting IterativeSummServer, then after starting ConcurrentSummServer...
 */

public class SummClient {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 3456;
        try {
            int count = Integer.parseInt(args[0]);
            long startTime = System.currentTimeMillis();

            Socket clientSocket = new Socket(serverHost, serverPort);
            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            ps.println(count);

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            int sum = Integer.parseInt(br.readLine());

            long endTime = System.currentTimeMillis();
            System.out.println("sum = " + sum);
            System.out.println("Time for receiving feedback from the server: " + (endTime - startTime) + " msec");

            clientSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
