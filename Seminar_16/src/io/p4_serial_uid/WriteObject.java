package io.p4_serial_uid;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *    A simple class to write / serialize the Address object into a file address.ser (in the current working dir)
 */

public class WriteObject{

    public static void main (String[] args) {

        Address address = new Address();
        address.setStreet("wall street");
        address.setCountry("united states");

        try{
            FileOutputStream fout = new FileOutputStream("address.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(address);
            oos.close();
            System.out.println("Done");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}