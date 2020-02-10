package com.grinkrug.app;

import com.grinkrug.greeter.*;

public class HelloApp {
    public static void main(String[] args) {
        Greeter greeter = Greeter.newInstance();
        System.out.println(greeter.greet("Modular Java"));
    }
}
