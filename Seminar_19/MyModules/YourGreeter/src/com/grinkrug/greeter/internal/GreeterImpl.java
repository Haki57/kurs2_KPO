package com.grinkrug.greeter.internal;

import com.grinkrug.greeter.Greeter;

public class GreeterImpl implements Greeter {
    @Override
    public String greet(String subject) {
        return "Hello, " + subject + " !!!";
    }
}
