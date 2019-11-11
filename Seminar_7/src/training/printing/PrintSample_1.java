package training.printing;

public class PrintSample_1 {

    static class A {
        private int number = 1;
        int getNumber(){
            System.out.println("number = " + number);
            return number;
        }
    }

    static class B extends A {
        int number = 2;
        int getNumber(){
            System.out.println("number = " + number);
            return number;
        }
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.number + a.getNumber());
        B b = new B();
        System.out.println(b.number + b.getNumber());
    }

}


