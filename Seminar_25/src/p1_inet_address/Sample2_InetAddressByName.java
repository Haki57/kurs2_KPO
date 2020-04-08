package p1_inet_address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
TODO: use console dialog to get info about IP-address...
    Try:
    - www.hse.ru
    - www.yandex.ru
    - www.grinkurg.org
    - www.grinkrug.com  -> www.grinkrug.com/66.96.149.18
    - 66.96.149.18
    - localHost
    - 127.0.0.1
    - ...
//*/

public class Sample2_InetAddressByName {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: \r\n");
        try {
            String name;
            while (!((name = br.readLine()).trim().equalsIgnoreCase("exit"))) {
                try {
                    InetAddress inetAddress = InetAddress.getByName(name);
                    System.out.println("inetAddress = " + inetAddress);
                    System.out.println("inetAddress.getHostName() = " + inetAddress.getHostName());
                    System.out.println("inetAddress.getCanonicalHostName() = " + inetAddress.getCanonicalHostName());

                    InetAddress[] allAddresses = InetAddress.getAllByName(name);
                    System.out.println("InetAddress.getAllByName(" + name + "): " + Arrays.toString(allAddresses));

                    for (InetAddress iAddress : allAddresses){
                        System.out.println("   hostName = " + iAddress.getHostName() +
                                ", canonicalHostName = " + iAddress.getCanonicalHostName() +
                                ", hostAddress = " + iAddress.getHostAddress() +
                                ", isMulticast = " + iAddress.isMulticastAddress()
                        );
                    }
                } catch (UnknownHostException uhex) {
                    System.out.println("got exception: " + uhex);
                }
                System.out.print("Enter String: \r\n");
            }
        } catch (IOException ioe) {
            System.out.println("Cannot read from System.in.");
        }
    }
}
