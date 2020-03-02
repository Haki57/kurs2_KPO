package structural.p4_flyweight;

import java.util.Properties;

/**
 * Test to demonstrate reuse of Interger objects while doing Integer.valueOf(int i)
 * and - implicitly - by assigning constant values for Integers.
 * TODO: check the same in C#...
 */

public class IntegerConstTest {

    public static void main(String[] args){

        Properties ps = System.getProperties();
        String integerHigh = ps.getProperty("java.lang.Integer.IntegerCache.high");
        System.out.println(integerHigh);

        Integer a, b;

        a = 100;
        b = 100;
        System.out.println(a == b);

        a = 10000;
        b = 10000;
        System.out.println(a == b);

        a = new Integer(100);
        b = new Integer(100);
        System.out.println(a == b);

        a = new Integer(100);
        b = new Integer(100);
        System.out.println(a.equals(b));

        a = Integer.valueOf(100);
        b = Integer.valueOf(100);
        System.out.println(a == b);

    }
}
