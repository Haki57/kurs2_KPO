package com.reflect.example;

import java.lang.reflect.Field;
import java.math.BigDecimal;

// TODO: read: https://www.logicbig.com/tutorials/core-java-tutorial/modules/illegal-access-operations.html
// TODO: we can set --illegal-access option in IDEA run configuration: e.g. VM options: --illegal-access=deny, etc.

public class ReflectiveAccessExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        BigDecimal bigDecimal = new BigDecimal(10.245);

        Field f = bigDecimal.getClass().getDeclaredField("scale");
        f.setAccessible(true);
        int scale = f.getInt(bigDecimal);
        System.out.println(scale);

        f = bigDecimal.getClass().getDeclaredField("precision");
        f.setAccessible(true);
        int precision = f.getInt(bigDecimal);
        System.out.println(precision);
    }
}
