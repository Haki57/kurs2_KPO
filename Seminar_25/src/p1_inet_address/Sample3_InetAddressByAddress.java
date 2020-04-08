package p1_inet_address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Sample3_InetAddressByAddress {
    public static void main(String[] args) {
        try {
            byte[] address1 = {107, 23, (byte)216, (byte)196}; //todo: explain - why the cast is needed sometime?
            InetAddress inetAddress1 = InetAddress.getByAddress(address1);
            System.out.println("inetAddress1 = " + inetAddress1);

            byte[] address2 = {107, 23, (byte)216, (byte)197};
            // TODO: note that NO validity checks are performed below:
            InetAddress inetAddress2 = InetAddress.getByAddress("www.nobodyknows.com", address2);
            System.out.println("inetAddress2 = " + inetAddress2);
        } catch (UnknownHostException uhex) {
            System.out.println("got exception: " + uhex);
        }
    }
}
