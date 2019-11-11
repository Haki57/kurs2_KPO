package training.operators;

//TODO:  https://www.tutorialspoint.com/Bitwise-right-shift-operator-in-Java   -- разобрать эту статью...


public class BitwiseOperators {
    public static void main(String[] args) {
        byte b = -0x80; //0x7F; //-0177; //-1; //-0b1000001; // binary literals are allowed since JDK 7...
        int shift = 6;
        byte c = b;
        System.out.println("b = " + b + ": " +Integer.toBinaryString(b));
        System.out.println("b: " + String.format("%8s", Integer.toBinaryString(0xFF & b)));

        b >>>= shift;
        System.out.println("b = " + b + ": " +Integer.toBinaryString(b));
        System.out.println("b: " + String.format("%8s", Integer.toBinaryString(0xFF & b)));

        c >>= shift;
        System.out.println("c = " + c + ": " +Integer.toBinaryString(c));
        System.out.println("c: " + String.format("%8s", Integer.toBinaryString(0xFF & c)));
    }
}

class Tester {
    public static void main(String[] args) {
        int a = 60;
        int b = -60;
        int c = 0;
//        System.out.println("60  = " + Integer.toBinaryString(a));
//        System.out.println("-60 = " + Integer.toBinaryString(b));
        System.out.println(a + " = " + Integer.toBinaryString(a));
        System.out.println(b + " = " + Integer.toBinaryString(b));

        //signed shift
        c = a >> 1;
//        System.out.println("60 >> 1  = " + Integer.toBinaryString(c));
        System.out.println(a + " >> 1  = " + Integer.toBinaryString(c));

        //unsigned shift
        c = a >>> 1;
//        System.out.println("60 >>> 1 = " + Integer.toBinaryString(c));
        System.out.println(a + " >>> 1 = " + Integer.toBinaryString(c));

        c = b >> 1;
//        System.out.println("-60 >> 1  = " + Integer.toBinaryString(c));
        System.out.println(b + " >> 1  = " + Integer.toBinaryString(c));

        c = b >>> 1;
//        System.out.println("-60 >>> 1  = " + Integer.toBinaryString(c));
        System.out.println(b + " >>> 1 = " + Integer.toBinaryString(c));
    }
}