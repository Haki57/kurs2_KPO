package io.p3_serialization;

import java.io.*;

class ExternalizableObject implements Externalizable {
    private static final long serialVersionUID = 2682896261039113935L;
    //final
    Object myObject = 5;

    public ExternalizableObject(){
        System.out.println(getClass().getName() + " default constructor invoked.");
    }

    public ExternalizableObject(Object o){
        System.out.println(getClass().getName() + " non default constructor invoked. Object -> " + o);
        myObject = o;
    }

    public Object getMyObject(){
        return myObject;
    }

    public void setMyObject(Object o){
        myObject = o;
    }

    public String toString() {
        return myObject.toString();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal(" + out + ")...");
        out.writeObject(getMyObject());
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal(" + in + ")...");
        setMyObject(in.readObject());
    }

    private void writeObject ( ObjectOutputStream out ) throws IOException {
        System.out.println("writeObject(" + out + ") invoked.");
        out.defaultWriteObject();
    }
    private void readObject ( ObjectInputStream in ) throws IOException, ClassNotFoundException {
        System.out.println("readObject("+ in +") invoked.");
        in.defaultReadObject();
    }
}

//TODO: compare speed - Serialization vs. Externalization.... (both to and from directions)
class ExternalizableTest {
    public static void main(String[] args){
        ExternalizableObject o1 = new ExternalizableObject(15);
        o1.setMyObject(7);

        System.out.println("Starting externalization / de-externalization...");

        File fw = new File("demo.dat");
        try {
           ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(fw));
//           ostream.writeObject(o1);
            o1.writeExternal(ostream);
            ostream.close();
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }

        System.out.println("now de-externalize...");
        // read object...
        File fr = new File("demo.dat");
        try {
            ObjectInputStream istream = new ObjectInputStream(new FileInputStream(fr));
//           ExternalizableObject o2 =(ExternalizableObject)istream.readObject();
            ExternalizableObject o2  = new ExternalizableObject(15);
            o2.readExternal(istream);
            istream.close();

            System.out.println("o2: "+ o2);
            System.out.println("o1.getMyObject().equals(o2.getMyObject()) -> " +
                    o1.getMyObject().equals(o2.getMyObject()));

        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }

        // delete tmp files:
        System.out.println("file " + fr.getName() + " deleted: " + fr.delete());
    }
}
