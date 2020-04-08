package p4_client_server.example_4;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * TODO: start the server first, then start this client and follow the console dialog...
 *
 */

public class ConnectionClient {
    public static void main(String[] args) {
        String serverHostName = "localhost";
        int serverPortNumber = 3456;

        try {
            if (args.length > 1){
                serverHostName = args[0];
                serverPortNumber = Integer.parseInt(args[1]);
            }

            InetAddress serverHost = InetAddress.getByName(serverHostName);
            System.out.println("creating clientSocket...");
            Socket clientSocket = new Socket(serverHost, serverPortNumber);
            System.out.println("clientSocket created...");

            Employee employee = new Employee();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter employee id:");
            int id = input.nextInt();
            System.out.println("Enter employee name (one word only):");
            String name = input.next();
            System.out.println("Enter employee salary:");
            double salary = input.nextDouble();
            employee.setId(id);
            employee.setName(name);
            employee.setSalary(salary);

            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(employee);

            oos.flush();
            clientSocket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
