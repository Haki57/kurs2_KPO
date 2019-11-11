package sample_6;

/**
 * TODO: explain the need for final (or effectively final - since JDK8(+)) variables used in anonymous classes...
    https://stackoverflow.com/questions/4732544/why-are-only-final-variables-accessible-in-anonymous-class
 we will return to this issue in the next lectures (dealing with closures)...
//*/

class MyBaseClass {
    private final String name;

    MyBaseClass(String name){
        this.name = name;
    }

    public void m1(){
        System.out.print(name);
    }
}

interface MyInterface {
    void m2();
    void m3();
}

public class MyAnonymousClasses {

//    static String s;

    public static void main(String[] args) {

        if (args.length == 0)
            args = new String[]{"Sidor"}; // here args[0] may be changed...

        final String s = args[0];

        new MyBaseClass(args[0]){
            @Override
            public void m1() {
                System.out.print("Mister ");
                super.m1();
                System.out.println(" is my best friend.");
            }
        }.m1();

        //TODO: note - the anonymous class instantiation...
        new MyInterface() {
//            String name = args[0]; //TODO: explain - why it does not compile instead of s below...
            String name = s;

            @Override
            public void m2(){
                System.out.print(name);
            }

            @Override
            public void m3() {
                System.out.print("Mister ");
                m2();
                System.out.println(" is NOT my best friend.");
            }
        }.m3();
    }
}

