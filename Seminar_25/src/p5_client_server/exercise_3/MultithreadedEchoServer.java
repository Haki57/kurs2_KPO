package p5_client_server.exercise_3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultithreadedEchoServer {

    public static void main(String[] args ) {
        int serverPort = 3456;
        if (args.length > 0)
            serverPort = Integer.parseInt(args[0]);

        try {
            System.out.println("MultithreadedEchoServer: awaiting clients on port " + serverPort + " ...");
            int i = 1;
            ServerSocket s = new ServerSocket(serverPort);
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class handles the client input for one server socket connection.
*/
class ThreadedEchoHandler implements Runnable {

    private Socket incoming;
    /**
     * Constructs a handler.
     * @param socket - the incoming socket
     */
    ThreadedEchoHandler(Socket socket) {
        incoming = socket;
    }

    public void run() {
        try {
            try {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

                // echo client input
                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    out.println(line);
                    if (line.trim().equalsIgnoreCase("BYE"))
                        done = true;
                }
            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}