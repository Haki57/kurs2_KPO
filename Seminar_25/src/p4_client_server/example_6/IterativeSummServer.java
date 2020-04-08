package p4_client_server.example_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO:
 */

public class IterativeSummServer {
    public static void main(String[] args) {
        try {
            int serverPort = 3456;
            if (args.length > 0)
                serverPort = Integer.parseInt(args[0]);
            ServerSocket sumServer = new ServerSocket(serverPort);
System.out.println("IterativeSummServer started...");
            while (true) {
                Socket dataSocket = sumServer.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
                int count = Integer.parseInt(br.readLine());

                int sum = 0;
                for (int i = 1; i <= count; i++) {
                    sum += i;
                    Thread.sleep(200); //just to simulate long calculation...
                }

                PrintStream ps = new PrintStream(dataSocket.getOutputStream());
                ps.println(sum);
                ps.flush();

                dataSocket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
