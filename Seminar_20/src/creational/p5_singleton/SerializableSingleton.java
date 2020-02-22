package creational.p5_singleton;

import java.io.Serializable;

/**
 * TODO: read -> Effective Java (j.Bloch), Chapter 11 - Serialization (Edition 2) OR Chapter 12 Serialization (in Edition 3).
 * TODO: read -> https://www.ibm.com/developerworks/ru/library/j-5things1/
 */
public class SerializableSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializableSingleton(){}

    private static class SingletonHelper{
        private static final SerializableSingleton instance = createInstance(); //new SerializableSingleton();
    }

    public static SerializableSingleton getInstance(){
        return SingletonHelper.instance;
    }

    // TODO: read about readResolve() method for Serializable objects...
    // TODO: it does not help sometimes - see https://sites.google.com/site/io/effective-java-reloaded (J.Bloch)
    protected Object readResolve() {
        System.out.println(this + ".readResolve() called...");
        return getInstance();
    }

    private static SerializableSingleton createInstance(){
        return new SerializableSingleton();
    }

}
