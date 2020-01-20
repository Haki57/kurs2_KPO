package io.p4_serial_uid;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
1. TODO: Read an article: http://www.mkyong.com/java-best-practices/understand-the-serialversionuid/

 A simple class to read / deserialize the Address object from file address.ser.

 2. Testing
 Let do some testing to demonstrate the use of serialVersionUID.

 2.1 Same serialVersionUID
 Same serialVersionUID , there is no problem during the deserialization process
 javac Address.java
 javac WriteObject.java
 javac ReadObject.java
 java WriteObject
 java ReadObject
 Street : wall street Country : united states

 2.2 Different serialVersionUID
 In Address.java, change the serialVersionUID to 2L (it was 1L), and compile it again.

 javac Address.java
 java ReadObject
 java.io.InvalidClassException: Address; local class incompatible:
 stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
 ...
 at ReadObject.main(ReadObject.java:_14)

 The InvalidClassException will raise, because you write a serialization class with serialVersionUID =1L
 but try to retrieve it back with updated serialization class, serialVersionUID  = 2L.

 The serialVersionUID have to match during the serialization and deserialization process.

 When should update your serialVersionUID?
 When your serialization class is updated with some incompatible Java type changes to a serializable class,
 you have to update your serialVersionUID.

 For detail about the compatible and incompatible Java type changes to a serializable class,
 see the Java Object Serialization Specification.

 3. What's wrong with the default serialVersionUID?

 If no serialVersionUID is declared, JVM will use its own algorithm to generate a default SerialVersionUID,
 you can check the algorithm here: https://docs.oracle.com/javase/6/docs/platform/serialization/spec/class.html#4100

 The default serialVersionUID computation is highly sensitive to class details and may vary from different
 JVM implementation, and result in an unexpected InvalidClassExceptions during the deserialization process.

 3.1 Client / Server environment

 - Client is using SUN's JVM in Windows.
 - Server is using JRockit in Linux.

 The client sends a serializable class with default generated serialVersionUID (e.g 123L) to the server over socket,
 the server may generate a different serialVersionUID (e.g 124L) during deserialization process,
 and raises an unexpected InvalidClassExceptions.

 3.2 File / Database environment

 - App #1 is using SUN's JVM in Windows.
 - App #2 is using JRockit in Linux.

 Serialization has allowed to save into a file or database.
 App #1 stores a serializable class into database by default generated serialVersionUID (e.g 123L),
 while App #2 may generate a different serialVersionUID (e.g 124L) during deserialization process,
 and raise an unexpected InvalidClassExceptions.
 You can check here for the List of the JVM implementation.

 4. How to generate serialVersionUID

 You can use JDK serialver.exe or Eclipse IDE to generate serialVersionUID automatically, see detail.

 Conclusion:
 SUN is highly recommended developers to declare the serialVersionUID in order to avoid the different JVM issue
 listed above, however I rather recommend you should understand what is serialization,
 how serialVersionUID implement version control and why your class need to use serialization.
 Understand the serialVersionUID concept is better than blindfold to any recommendation.
 */

public class ReadObject{

public static void main (String[] args) {
        Address address;
        try{
            FileInputStream fin = new FileInputStream("address.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            address = (Address) ois.readObject();
            ois.close();
            System.out.println(address);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}