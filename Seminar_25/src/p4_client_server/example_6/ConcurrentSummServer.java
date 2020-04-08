package p4_client_server.example_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO: when dealing with this server from client start client two times:
 *  1). args[0] = 100
 *  2). args[0] = 5
 */
public class ConcurrentSummServer {
    public static void main(String[] args) {
        try {
            int serverPort = 3456;
            ServerSocket sumServer = new ServerSocket(serverPort);
System.out.println("ConcurrentSummServer started...");
            while (true) {
                Socket socket = sumServer.accept();
                Thread thread = new SummThread(socket);
                thread.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class SummThread extends Thread {
    Socket clientSocket;

    SummThread (Socket s) {
        clientSocket = s;
    }

    public void run () {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            int count = Integer.parseInt(br.readLine());

            int sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += i;
                Thread.sleep(200); //just to simulate long calculation...
            }
            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            ps.println(sum);
            ps.flush();
            clientSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}