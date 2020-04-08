package p1_inet_address;

import java.net.InetAddress;
import java.net.UnknownHostException;

// TODO: try to put it into Firefox addressing string: http://"5.255.255.88"

public class Sample4_InetAddressReverseTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia1 = InetAddress.getByName("5.255.255.88");
        InetAddress ia2 = InetAddress.getByName("www.yandex.ru");
        System.out.println("ia1 = " + ia1);
        System.out.println("ia2 = " + ia2);

        System.out.println("(ia1 == ia2) -> " + (ia1 == ia2));
        System.out.println("ia1.equals(ia2) -> " + ia1.equals(ia2)); //TODO: note - how equals() - works (by IP only...)

        System.out.println(ia1.getHostName()); // just tries to use cash in InetAddess class...
        System.out.println(ia1.getCanonicalHostName()); // getCanonicalHostName() forces to ask DNS and update the cach...
    }
}
