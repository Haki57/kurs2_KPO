package p5_client_server.exercise_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsoleEchoServer {

    private AtomicBoolean isServerRunning;
    private ServerSocket serverSocket;
    private ServerActivity serverActivity;

    private ConsoleEchoServer(int serverPort){
        try {
            serverSocket = new ServerSocket(serverPort);
            isServerRunning = new AtomicBoolean(true);
            serverActivity = new ServerActivity(serverSocket, isServerRunning);
        } catch (Exception ex) {
            //
        }
    }

    private void execute() throws Exception {
        serverActivity.start();
        // read from console hit...
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true){
            if ((s = scanner.nextLine()).equalsIgnoreCase("exit")) break;
        }
        shutdown();
    }

    private void shutdown() throws IOException {
        isServerRunning.set(false);
        serverActivity.interrupt(); // question: will it interrupt accept()-method ?
        serverSocket.close();
    }

    public static void main(String[] args) {
        int serverPort = 3456;
        try {
            if (args.length > 0) serverPort = Integer.parseInt(args[0]);
            new ConsoleEchoServer(serverPort).execute();
        } catch (Exception ex){
            ex.printStackTrace();
            System.err.println("Could not create server.");
            System.exit(1);
        }
    }
}

class ServerActivity extends Thread {

    private final ServerSocket serverSocket;
    private final AtomicBoolean isServerRunning;

    ServerActivity (ServerSocket serverSocket, AtomicBoolean isServerRunning) {
        this.isServerRunning = isServerRunning;
        this.serverSocket = serverSocket;
    }

    public void run(){
System.out.println(getClass().getName() + ".run() invoked.");
        while (isServerRunning.get()){
            try {
System.out.println("calling accept()...");
                Socket socket = serverSocket.accept(); //Question: how to interrupt accept()-method ?
System.out.println("accept() performed...");
                new ClintServerCommunication(socket).start();
            } catch (IOException ioex){
                //ioex.printStackTrace();
                System.out.println("got exception: " + ioex);
            }
        }
        System.out.println("server activity finished...");
    }
}

class ClintServerCommunication extends Thread {
    private final Socket socket;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    ClintServerCommunication (Socket socket) throws IOException {
        this.socket = socket;
        printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
System.out.println(getClass().getName() + ".run() invoked.");
        try {
            while (!isInterrupted()) {
                String clientString = bufferedReader.readLine();
            System.out.println("from Client: " + clientString);
                printStream.println(clientString); // just echo...
                printStream.flush();
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
