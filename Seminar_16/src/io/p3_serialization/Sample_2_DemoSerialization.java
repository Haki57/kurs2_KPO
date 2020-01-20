package io.p3_serialization;

import java.io.*;

class Human implements Serializable
{
    String eyesColor = "black";

    Human(){
        System.out.println("oi, i am called !!!");
    } //TODO: explain the need for that default constructor...

    Human(String c){
        System.out.println("Human(" + c + ") invoked.");
        eyesColor = c;
    }
    void setColor(String s){
        eyesColor = s;
    }
}

class Student extends Human implements Serializable
{
    static String faculty; //TODO: see - is that saved/restored?

    private String name;
    private int id;

    private transient String password; //TODO: see - is that saved/restored?

    Student(String nameOfFaculty, String name, int id, String password){
        super(null);
        System.out.println("Student constructor invoked...");
        faculty = nameOfFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public String toString(){
        return "\nfaculty " + faculty + "\nname " + name + "\nID " + id + "\npassword " + password + "\neyes = " + eyesColor;
    }
}


class DemoSerialization {

    public static void main(String[] args) {
        // Create and write an object
        Student student = new Student("SE", "Sidorov", 1, "180PI");
        student.setColor("blue");
        System.out.println(student);

        File fw = new File("demo.dat");
        try {
            ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(fw));
            ostream.writeObject(student);
            ostream.close();
        } catch (IOException e) {
            System.err.println("got exception: " + e);
        }

        student.faculty = "BI";// changing a static field value...
        // read and output object...
        File fr = new File("demo.dat");
        try {
            ObjectInputStream istream = new ObjectInputStream(new FileInputStream(fr));
            Student unknown =(Student)istream.readObject();
            istream.close();
            System.out.println(unknown);
        } catch (ClassNotFoundException ce) {
            System.err.println("got exception: " + ce);
            System.err.println("Class does not exist");
        } catch (FileNotFoundException fe) {
            System.err.println("got exception: " + fe);
            System.err.println("File not found");
        } catch (IOException ioe) {
            System.err.println("got exception:" + ioe);
            System.err.println("File access error");
        }

        // delete tmp file:
        System.out.println("file " + fr.getName() + " deleted: " + fr.delete()) ;
    }
}
