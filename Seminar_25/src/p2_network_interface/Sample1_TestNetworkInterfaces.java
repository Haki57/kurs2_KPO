package p2_network_interface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/*
    NetworkInterface позволяет узнать "сетевые возможности" данного компьютера.
    Имеются фабричные методы получения объектов NetworkInterface.
    Имея NetworkInterface-объект, можно получить связанные с ним объекты-InetAddress'es
 */
public class Sample1_TestNetworkInterfaces {
    public static void main(String[] args) throws SocketException {

        System.out.println("getNetworkInterfaces():");
        List<String> names = new ArrayList<>();
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
            names.add(ni.getName()); // names are platform dependent...
        }

        System.out.println();
        System.out.println("getByInetAddress():");
        try {
            InetAddress local = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni = NetworkInterface.getByInetAddress(local);
            if (ni == null) {
                System.err.println("That's weird. No local loopback address.");
            } else {
                System.out.println(ni);
            }
        } catch (SocketException ex) {
            System.err.println("Could not list network interfaces." );
        } catch (UnknownHostException ex) {
            System.err.println("That's weird. Could not lookup 127.0.0.1.");
        }

        System.out.println();
        System.out.println("getByName():");
        for (String name : names) {
            System.out.print("*** " + name + ": ");
            NetworkInterface ni = NetworkInterface.getByName(name);
            System.out.println(" displayName = " + ni.getDisplayName());
            Enumeration addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                System.out.println(addresses.nextElement());
            }
        }
    }
}
