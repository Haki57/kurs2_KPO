package p5_client_server.exercise_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

    public static void main(String[] args) throws IOException {
        String serverHost = "localHost";
        int serverPort = 3456;

        if (args.length > 1) {
            serverHost = args[0];
            serverPort = Integer.parseInt(args[1]);
        }

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            System.out.println("Client: started...");
            socket = new Socket(serverHost, serverPort);
            System.out.println("Client: socket created...");

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHost);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + serverHost);
            System.exit(1);
        }

        //TODO: note, that the following is fixing the issue mentioned above....
//        System.out.println("Ready to work: " + in.readLine());

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        while ((userInput = stdIn.readLine()) != null) {
            if (userInput.equalsIgnoreCase("bye"))
                break;
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}
