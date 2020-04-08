package p3_client_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * TODO: the sample shows how to write to a socket and read a reply from it.
 * We use whois.internic.net server to communicate with...
 */

public class Sample_4_Writing {
    public static void main(String[] args) {
        //TODO: try-with-resource will close the socket:
        String host = "whois.internic.net";
//        String host = "whois.nic.ru";
        int port = 43;
        try ( Socket connection = new Socket(host, port) ) {
            System.out.println("...socket connected...");
            Writer out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");
            out.write("google.com\r\n");
//            out.write("grinkrug.com\r\n");
//            out.write("yandex.ru\r\n");
//            out.write("hse.edu\r\n"); // why it is missing at the host requested? Nobody knows...

            out.flush();
            connection.shutdownOutput(); //TODO: we ask for the info and close writing to the socket...

            InputStream inStream = connection.getInputStream(); //TODO: we continue with reading from the socket...
            Scanner in = new Scanner(inStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException ioex) {
            System.err.println("got exception: " + ioex);
            ioex.printStackTrace();
        }
    }
}
