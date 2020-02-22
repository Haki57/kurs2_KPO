package com.grinkrug.greeter;

public interface Greeter {
    static Greeter newInstance() {
        return new com.grinkrug.greeter.internal.GreeterImpl();
    }
    String greet(String subject);
}
