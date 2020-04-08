package p3_client_socket;

import java.io.InputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    TODO: see how to read info from a socket...
 */

public class Sample_3_Reading {
    public static void main(String[] args) throws NumberFormatException {
        String host = "time-A.timefreq.bldrdoc.gov";
//        String host = "time-a.nist.gov";
        int port = 13;
        if (args.length > 1) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        // TODO: note - try-with-resource closes the socket (to free port, etc.):
        try (Socket s = new Socket(host, port)) {
            System.out.println("socket created...");

            InputStream inStream = s.getInputStream(); //TODO: after that - just use well known input features...
            Scanner in = new Scanner(inStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                if (line.length() > 0)
                    System.out.println(parseDate(line));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Date parseDate(String s) throws ParseException {
//        System.out.println("got string: " + s);
        String[] pieces = s.split(" ");
        String dateTime = pieces[1] + " " + pieces[2] + " UTC";
        DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
        return format.parse(dateTime);
    }
}
