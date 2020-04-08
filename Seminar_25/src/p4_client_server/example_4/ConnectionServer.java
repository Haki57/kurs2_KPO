package p4_client_server.example_4;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO: start this server, then start its' client and see whats' going on...
 */
public class ConnectionServer {
    public static void main(String[] args) {
        int serverPortNimber = 3456;

        try {
            if (args.length > 0) {
                serverPortNimber = Integer.parseInt(args[0]);
            }
            ServerSocket connectionSocket = new ServerSocket(serverPortNimber);

            System.out.println("calling accept()...");
            Socket dataSocket = connectionSocket.accept();
            System.out.println("accept() performed: dataSocket = " + dataSocket);

            ObjectInputStream ois = new ObjectInputStream(dataSocket.getInputStream());
            Employee employee = (Employee)ois.readObject();

            System.out.println("Employee: id = " + employee.getId()
                    + " name = " + employee.getName()
                    + " salary = " + employee.getSalary());

            dataSocket.close();
            connectionSocket.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
