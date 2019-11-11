package edu.hse.cs.se;

public class Q12_ExceptionsQuiz {
    public static void main(String[] args) {
        EJavaBase obj = new EJavaDerived();
        obj.myMethod();
    }
}

class EJavaBase {
    void myMethod() throws ExceptionInInitializerError {
        System.out.println("Base");
    }
}

class EJavaDerived extends EJavaBase {
    void myMethod() throws RuntimeException {
        System.out.println("Derived");
    }
}