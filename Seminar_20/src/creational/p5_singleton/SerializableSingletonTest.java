package creational.p5_singleton;

import java.io.*;

/**
 */
public class SerializableSingletonTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        SerializableSingleton instanceOne = SerializableSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream( new FileOutputStream( "testSingleton.ser" ));
        out.writeObject(instanceOne);
        out.close();

        //deserialize from file to object
        ObjectInput in = new ObjectInputStream( new FileInputStream( "testSingleton.ser" ));
        SerializableSingleton instanceTwo = (SerializableSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode = " + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode = " + instanceTwo.hashCode());
        System.out.println("instanceOne == instanceTwo : " + (instanceOne == instanceTwo));
    }
}