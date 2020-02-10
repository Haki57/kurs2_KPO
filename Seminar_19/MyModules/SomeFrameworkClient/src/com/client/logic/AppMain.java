package com.client.logic;

// TODO: read: https://www.logicbig.com/tutorials/core-java-tutorial/modules/reflective-access.html

import com.util.PropertyUtil; //TODO: to compile add module dependency (on module SomeFramework...)
import java.util.Map;

public class AppMain {
    public static void main(String[] args) throws IllegalAccessException {
        SomeObject object = new SomeObject(7, "test-string");
        Map<String, Object> map = PropertyUtil.getFieldValueMap(object);
        System.out.println(map);
    }
}
