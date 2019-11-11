package sample_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyTraceHandler implements InvocationHandler {

    private Object target;

    public MyTraceHandler(Object o){
        target = o;
    }
    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("." + m.getName() + "(");
        // print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
        // invoke actual method
        return m.invoke(target, args);
    }

    public static class MyProxyTest {
        public static void main(String[] args){
//        System.out.println("MyProxyTest.class.getClassLoader() = " + MyProxyTest.class.getClassLoader());
            MyTestInterface1 p = (MyTestInterface1) Proxy.newProxyInstance(
                MyProxyTest.class.getClassLoader(),
                new Class[]{
                    MyTestInterface1.class
                        ,
                    MyInterface2.class
                },
                new MyTraceHandler(new MyTestInterface1() {
                    @Override
                    public Object m1(int i) {
                        System.out.println(this + ".m1(" + i + ") invoked; returning null...");
                        return null;
                    }
                })
            );
            p.m1(5);

            Class proxyClass = p.getClass();
//            System.out.println("proxyClass.isSynthetic() = " + proxyClass.isSynthetic());
            System.out.println("proxyClass = " + proxyClass + ", proxyClass.getClassLoader() = " + proxyClass.getClassLoader());
        }
    }
}
