package sample1;

public class JNIHelloWorld {

    static {
        System.loadLibrary("JNIHelloWorld");
    }

    public static void main(String[] args) {
        JNIHelloWorld instance = new JNIHelloWorld();
        instance.printHelloWorld();
    }

    public native void printHelloWorld();
}
