package p2_network_interface;

import p1_inet_address.Sample5_MyAddressBytes;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class Sample2_NetworkInterfacesTest {

    public static void main(String[] args) throws SocketException {
        System.out.println("NetworkInterfaces:");
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
            byte[] hardwareAddress = ni.getHardwareAddress();
            if (hardwareAddress != null)
                System.out.println("    hardware Address: " + Sample5_MyAddressBytes.bytes2dottedString(hardwareAddress));

            Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                System.out.println("    inetAddress: "  + inetAddress);
            }

            List<InterfaceAddress> interfaceAddresses =  ni.getInterfaceAddresses();
            for (InterfaceAddress interfaceAddress : interfaceAddresses){
                System.out.println("    interfaceAddress: " + interfaceAddress);
            }
        }
    }
}
