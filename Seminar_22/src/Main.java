import java.util.logging.Level;

//TODO: below are samples of the design patterns that can be found in JDK...

public class Main {

    public static void main(String[] args) {
        /* Creational */

        // Factory Method
        java.util.Calendar.getInstance();

        // Abstract Factory
        javax.xml.parsers.DocumentBuilderFactory.newInstance();

        // Builder
        new StringBuilder().append(new Object());
        new StringBuffer().append(new Object());

        // Prototype
        new Cloneable(){
            public Object clone() {
                Object result = null;
                try{
                     result = super.clone();
                }catch (CloneNotSupportedException ex){
                    System.err.println("got exception: " + ex);
                }
                return result;
            }
        }.clone();

        // Singleton
        Runtime.getRuntime();

        /* Structural */

        // Adapter
        java.util.Arrays.asList();
        java.util.Collections.list(null);
        new java.io.InputStreamReader(null);
        new java.io.OutputStreamWriter(null);

        // Composite
        new java.awt.Container().add((java.awt.Component)null);

        // Decorator
        new java.io.BufferedInputStream(null);

        // Flyweight
        Integer.valueOf(0);

        // Proxy
        java.lang.reflect.Proxy.newProxyInstance(null, null, null);

        /* Behavioral */

        // Chain of Responsibility
        java.util.logging.Logger.getLogger("").log(Level.INFO, "");

        // Command (All implementations of the interfaces)
        javax.swing.Action z;

        // Iterator (All implementations of the interfaces)
        java.util.Iterator iterator;
        java.util.Enumeration enumeration;

        // Mediator
        java.util.Timer timer;

        // Memento
        java.util.Date date;
        java.io.Serializable serializable; // All implementations of the interface

        // Observer (All implementations of the interface)
        java.util.EventListener eventListener;

        // State (JEE)
//        javax.faces.lifecycle.LifeCycle.execute;

        // Strategy (All implementations of the interface)
        java.util.Comparator comparator;

        // Template Method (All non-abstract methods)
        java.io.InputStream inputStream;
        java.io.OutputStream outputStream;
        java.io.Reader reader;
        java.io.Writer writer;

        // Visitor
        java.nio.file.FileVisitor fileVisitor; // All implementations of the interface
        java.nio.file.SimpleFileVisitor simpleFileVisitor;
    }
}
