package io.p3_serialization;

import java.io.*;

class NonSerializableObject //implements Serializable
{
//    private static final long serialVersionUID = 3419893035079059028L;
    private Object o = 5;

    //todo: test that this default constructor can be called during serialization/deserialization...
    //todo: show that the b7_state of the object can be changed when dealing with non-serializable superclass...
    public NonSerializableObject(){
        System.out.println("NonSerializableObject()...");
    }

    public NonSerializableObject(Object p){
        this.o = p;
        System.out.println("NonSerializableObject(" + p + ")...");
    }
    public void setObject(Object o){
        this.o = o;
    }
    public Object getObject(){
        return o;
    }

    private void writeObject ( ObjectOutputStream out ) throws IOException {
        System.out.println("NonSer: writeObject(" + out + ") invoked.");
    }
    private void readObject ( ObjectInputStream in ) throws IOException, ClassNotFoundException {
        System.out.println("NonSer: readObject("+ in +") invoked.");
    }
}

class SerializableObject extends NonSerializableObject implements Serializable {

//    private static final long serialVersionUID = -4461910628704995714L;

    private Object num = 5;

    public SerializableObject(){
        super(5);
        System.out.println("SerializableObject()...");
    }
    public SerializableObject(Object p){
        super(p);
        System.err.println("SerializableObject(" + p + ")...");
    }
    public void setNum(Object v){
        num = v;
    }
    public Object getNum(){
        return num;
    }

    private void writeObject ( ObjectOutputStream out ) throws IOException {
        System.out.println("writeObject(" + out + ") invoked.");
        out.defaultWriteObject();
        out.writeObject(getObject());
    }
    private void readObject ( ObjectInputStream in ) throws IOException, ClassNotFoundException {
        System.out.println("readObject("+ in +") invoked.");
        in.defaultReadObject();
        setObject(in.readObject());
    }
}

class SerializableTest {
    public static void main(String[] args){
        SerializableObject o1 = new SerializableObject();
        o1.setNum(7);
        o1.setObject(7);
        System.out.println("o1.number: " + o1.getNum());
        System.out.println("o1.object: " + o1.getObject());

        System.out.println("Starting serialization...");

        File fw = new File("demo.dat");
        try {
           ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(fw));
           ostream.writeObject(o1);
           ostream.close();
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }

        // read object...
        System.out.println("Starting deserialization...");
        SerializableObject o2 = null;
        File fr = new File("demo.dat");
        try {
            ObjectInputStream istream = new ObjectInputStream(new FileInputStream(fr));
            o2 =(SerializableObject)istream.readObject();
            istream.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        if(o2 != null){
            System.out.println("o2.number: " + o2.getNum());
            System.out.println("o2.object: " + o2.getObject());
        }

        // delete tmp files:
        System.out.println("file " + fr.getName() + " deleted: " + fr.delete());
    }
}
