package com.util;

// TODO: read: https://www.logicbig.com/tutorials/core-java-tutorial/modules/reflective-access.html

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PropertyUtil {
    public static Map<String, Object> getFieldValueMap(Object object) throws IllegalAccessException {
        Class<?> theClass = object.getClass();
        Field[] declaredFields = theClass.getDeclaredFields();
        Map<String, Object> fieldsMap = new HashMap<>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object fieldValue = declaredField.get(object);
            fieldsMap.put(declaredField.getName(), fieldValue);
        }
        return fieldsMap;
    }
}
