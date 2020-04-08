package p5_client_server.exercise_1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleEchoClient {
    private static int COUNTER = 0;

    private final Socket socket;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    private ConsoleEchoClient(String serverHost, int serverPort) throws Exception {
        socket = new Socket(serverHost, serverPort);
        printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!(s = scanner.nextLine()).equalsIgnoreCase("exit")){
            printStream.println(s);
            printStream.flush();
            String serverString = bufferedReader.readLine(); // how to interrupt that reading?
System.out.println("from Server: " + serverString);
//            System.out.println('\r');
        }
        System.out.println("good bye...");
        socket.close();
    }

    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 3456;

        if (args.length > 1){
            try{
                serverHost = args[0];
                serverPort = Integer.parseInt(args[1]);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        try {
            new ConsoleEchoClient(serverHost, serverPort).execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
