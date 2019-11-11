package generic.p2_misc;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

//TODO: look at the method min() and print its' signature to see what is the type of T after compilation...

public class TestMinElement {
    public static void main(String[] args) {
        String min = min(args);
        System.out.println(min);

        printTypeOfT();
    }

    private static <T extends Comparable<T> & Serializable> T min (T[] a ) {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++)
            if ( smallest.compareTo(a[i]) > 0 )
                smallest = a[i];
        return smallest;
    }

    private static void printTypeOfT() {
        try {
            Method[] methods = TestMinElement.class.getDeclaredMethods();
            System.out.println(Arrays.toString(methods));
        } catch (Exception ex) {
            System.out.println("got exception: " + ex);
        }
    }

}
