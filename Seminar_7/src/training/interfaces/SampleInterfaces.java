package training.interfaces;

import java.util.Random;

public class SampleInterfaces {}

//TODO: pay attention on warnings about unused methods and other elements in code...

interface I1 {
    //TODO: note that static constants are available in training.interfaces fromm the very beginning (JDK1.0):
    //public static final //TODO: fields in training.interfaces are public static final by definition
    int INT_VALUE = 5; //TODO: static final fields in interface must be initialized
    //public static final
    Random MY_RANDOM = new Random();
    //public
    int method1(int p);  // TODO: abstract instance method (is public by definition)

    //TODO: static methods in training.interfaces (since JDK 8):
    //public //TODO: public is redundant for interface methods
    static int staticMethod(int p) {
        return p + MY_RANDOM.nextInt();
    }

    //public
    default int method2(int p) {
        return helper(p); //TODO: default method is implemented using private method in interface
    }

    private int helper(int p) {
        return method1(p); //TODO: private method is implemented using abstract method of the interface
    }
}

interface I2 extends I1 {
    //public static final
    int INT_VALUE = MY_RANDOM.nextInt();
    //public
    static int staticMethod(int p) {
        return multiply(p , new Random().nextInt()); //TODO: public static method is implemented using private static method in the interface
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    //public
    default int method1(int p) {
//        return I1.super.method1(p); //TODO: note that we cannot delegate to the super-interface implementation...
        return staticMethod(p);  //TODO: default method is implemented using static method...
    }

}

interface I3 {
    int method3(int p);
    default int m3(int p) {
        return method3(p);
    }
}
interface I4 {
    int method3(int p);
    default int m4(int p) {
        return method3(p);
    }
}

class C1 implements I1, I2, I3, I4
{
    private int anInt;

    private C1() {
        anInt = method1(I1.INT_VALUE) + method2(MY_RANDOM.nextInt());
    }

    @Override
    public int method1(int p) {
        return p + getAnInt();
    }

    private int getAnInt() {
        return anInt;
    }

    @Override
    public int method2(int p) {
        return I2.super.method1(p);
//        return I1.super.method1(p); //TODO: error: method1 is extended in I2...
    }

    public int method3(int p) {
//        return 3; //TODO: both I2 and I3 have abstract method3() and the class must have the concrete implementation...
        return m3(p) + m4(p);
    }

    public static void main(String[] args) {
        System.out.println(new C1().method1(I1.INT_VALUE));
        System.out.println(I1.staticMethod(I1.INT_VALUE)); //TODO: static method must be accessed through containing interface
        System.out.println(I2.staticMethod(I2.INT_VALUE)); //TODO: static method must be accessed through containing interface
        System.out.println(new C1().method1(MY_RANDOM.nextInt()));
        System.out.println(new C1().method2(MY_RANDOM.nextInt()));

        System.out.println(new C2());
    }
}

class C2 implements I2, I3, I4 {
    @Override
    public int method2(int p) {
        return I2.super.method2(p);
    }

    @Override
    public int method3(int p) {
        return p;
    }
}