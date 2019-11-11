package training.printing;

public class PrintSample {
    static class A {
        int a = 1;
        public int getA() {return a;}
    }
    static class B extends A {
        int a = 2;
        public int getA() {return a;}
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.a);
        System.out.println(a.getA());
        System.out.println("----------------------------------------------------");
        A b = new B();
        System.out.println(b.a);
        System.out.println(b.getA());
        System.out.println("----------------------------------------------------");
        B c = new B();
        System.out.println(c.a);
        System.out.println(c.getA());
        System.out.println("----------------------------------------------------");
    }
}
