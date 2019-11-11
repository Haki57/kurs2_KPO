package training.interfaces;

import java.util.Random;

public class SampleInterfaces2 {}

interface Interface1 {
    int m11(int p);
    default int m12(int p) {
        System.out.println("p = " + p);
        return m11(p);
    }

    static int useDefaultMethod(Interface1 interface1, int p) {
        return interface1.m12(p);
    }
}
interface Interface2 extends Interface1 {
    // TODO:  we can override abstract method with our default method...
    default int m11(int p) {
        System.out.println("p = " + p);
        return m12(p);
    }

    // TODO: we can override default-method with our abstract method...
    @Override
    int m12(int p);

    // TODO: we cannot override an abstract instance method with our static method...
//    static int m11(int p) {
//        return p;
//    }

    // TODO: we cannot override a default instance method with our static method...
//    static int m12(int p) {
//        return p;
//    }
}

class C implements Interface1, Interface2 {
    private static final Random MY_RUNDOM = new Random();

    public static void main(String[] args) {
        System.out.println(new C().m12(MY_RUNDOM.nextInt()));
        System.out.println(Interface1.useDefaultMethod(new C(), MY_RUNDOM.nextInt()));
    }

    @Override
    public int m11(int p) {
        return MY_RUNDOM.nextInt() + p;
    }

    @Override
    public int m12(int p) {
        return 0;
    }

}