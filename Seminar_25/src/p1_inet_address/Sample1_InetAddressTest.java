package p1_inet_address;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 *  InetAddress class has no visible constructors; InetAddress objects are created by factory methods.
 *  Этот пример показывает операции/методы с объектами InetAddress.
 *  Полезно смотреть javadoc-описания этих методов и их реализации в исходных кодах.
 *
 */
public class Sample1_InetAddressTest {
    public static void main(String[] args) {
        try {
            System.out.println("About my computer: ");
            InetAddress localHostAddess = InetAddress.getLocalHost();
            System.out.println("localHostAddress = " + localHostAddess);
            System.out.println("hostName = " + localHostAddess.getHostName());
            System.out.println("canonicalHostName = " + localHostAddess.getCanonicalHostName());

            System.out.println();
            System.out.println("About www.hse.ru: ");
            InetAddress[] allByName = InetAddress.getAllByName("www.hse.ru");
            System.out.println("allByName = " + Arrays.toString(allByName));
            InetAddress addressByName = InetAddress.getByName("www.hse.ru");
            System.out.println("addressByName = " + addressByName);
            System.out.println("hostName = " + addressByName.getHostName());
            System.out.println("canonicalHostName = " + addressByName.getCanonicalHostName()); //todo - note: it takes time...
            System.out.println("isMulticastAddress = " + addressByName.isMulticastAddress());

            System.out.println();
            System.out.println("About www.yandex.ru: ");
            InetAddress[] addressesByName = InetAddress.getAllByName("www.yandex.ru");
            for (InetAddress ia: addressesByName) {
                System.out.println("addressesByName = " + ia + "; class = " + ia.getClass());
            }
        } catch (UnknownHostException uhe){
            System.out.println("got exception: " + uhe);
        }
    }
}
