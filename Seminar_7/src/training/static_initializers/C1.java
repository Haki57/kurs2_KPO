package training.static_initializers;

class C_1 {
    static {
        System.out.println("C_1: static initializer invoked...");
    }
    static void staticMethod(){
        System.out.println("C_1: staticMethod() invoked...");
        new C_3();
    }
}
class C_2 extends C_1 {
    static {
        System.out.println("C_2: static initializer invoked...");
    }
//    static void staticMethod(){ System.out.println("C_2: staticMethod() invoked...");}
}
class C_3 extends C_2 {
    static {
        System.out.println("C_3: static initializer invoked...");
    }
//    static void staticMethod(){ System.out.println("C_3: staticMethod() invoked...");}
}

class Test {
    public static void main(String[] args) {
        // case 1:
//        C_1.staticMethod();
        // case 2:
//        C_2.staticMethod();
        // case 3:
        C_3.staticMethod();
        // TODO: now comment out staticMethod() in С_2 and C_3 and run again...
        // TODO: Why static initializers of C_2 and C_3 have not been executed? - That's because of the "lazy fashion"...
        // Java compiler optimizes code to perform only those operations that and when they are absolutely needed...
    }
}
