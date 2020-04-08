package p1_inet_address;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Sample5_MyAddressBytes {
    public static void main(String[] args) {
        try {
            InetAddress me = InetAddress.getLocalHost();
            System.out.println("me = " + me);
            byte[] bytes = me.getAddress();
            System.out.println("My address is (just bytes): " + Arrays.toString(bytes)); // why we see negatives?
            System.out.println("My address is (converted) : " + bytes2dottedString(bytes));
        } catch (UnknownHostException ex) {
            System.out.println("I'm sorry. I don't know my own address.");
        }
    }

    public static String bytes2dottedString(byte[] bytes) {
        String before = "";
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(before);
            result.append(String.valueOf(b < 0 ? b + 256 : b));
            before = ".";
        }
        return result.toString();
    }

}
