package p1_inet_address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    TODO: try the following addresses / names:
    - 127.0.0.1
    - 192.168.254.32
    - www.oreilly.com //TODO: don't cut & paste, just enter...(Idea tries to use file - protocol...)
    - www.yandex.ru
    - 224.0.2.1
    - FF01:0:0:0:0:0:0:1
    - FF05:0:0:0:0:0:0:101
    - 0::1
    TODO: read the javadocs for the corresponding methods...
 */

public class Sample6_IPAddressCharacteristics {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: \r\n");
        try {
            String name;
            while (!((name = br.readLine()).trim().equalsIgnoreCase("exit"))) {
                try {
                    InetAddress address = InetAddress.getByName(name);
                    if (address.isAnyLocalAddress()) {
                        System.out.println(address + " is a wildcard address.");
                    }
                    if (address.isLoopbackAddress()) {
                        System.out.println(address + " is loopback address.");
                    }
                    if (address.isLinkLocalAddress()) {
                        System.out.println(address + " is a link-local address.");
                    } else if (address.isSiteLocalAddress()) {
                        System.out.println(address + " is a site-local address.");
                    } else {
                        System.out.println(address + " is a global address.");
                    }
                    if (address.isMulticastAddress()) {
                        if (address.isMCGlobal()) {
                            System.out.println(address + " is a global multicast address.");
                        } else if (address.isMCOrgLocal()) {
                            System.out.println(address + " is an organization wide multicast address.");
                        } else if (address.isMCSiteLocal()) {
                            System.out.println(address + " is a site wide multicast address.");
                        } else if (address.isMCLinkLocal()) {
                            System.out.println(address + " is a subnet wide multicast address.");
                        } else if (address.isMCNodeLocal()) {
                            System.out.println(address + " is an interface-local multicast address.");
                        } else {
                            System.out.println(address + " is an unknown multicast address type.");
                        }
                    } else {
                        System.out.println(address + " is a unicast address.");
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
