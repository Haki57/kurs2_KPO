package io.p3_serialization;

import java.util.Arrays;

public class Sample_1_SerializableObjectsTest {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(int.class.getInterfaces()));
        System.out.println(Arrays.toString(Integer.class.getInterfaces()));
        System.out.println(Arrays.toString(int[].class.getInterfaces()));
    }
}
