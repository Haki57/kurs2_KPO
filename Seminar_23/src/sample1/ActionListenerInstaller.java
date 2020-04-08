package sample1;

import java.awt.event.ActionListener;
import java.lang.reflect.*;
import java.util.Arrays;

class ActionListenerInstaller {
    /**
     * Processes all ActionListenerFor annotations in the given object.
     * @param obj an object whose methods may have ActionListenerFor annotations
     */
    static void processAnnotations(Object obj) {
        try {
            Class<?> cl = obj.getClass();
            for (Method m : cl.getDeclaredMethods()) {
                ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
                if (a != null) {
                    //========= debug ==================================================================================
                    // following is to test - what is being returned?
                    System.out.println("a = " + a);
                    System.out.println("a.getClass() = " + a.getClass()); // todo: note - a proxy instance is returned...
                    Class[] interfaces = a.getClass().getInterfaces();    // todo see: what are the interfaces supported by the proxy?
                    System.out.println(Arrays.toString(interfaces));
                    //==================================================================================================
                    Field f = cl.getDeclaredField(a.source());
                    f.setAccessible(true);
                    addListener(f.get(obj), obj, m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds an action listener that calls a given method.
     * @param source the event source to which an action listener is added
     * @param param the implicit parameter of the method that the listener calls
     * @param m the method that the listener calls
     */
    private static void addListener(Object source, final Object param, final Method m)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
System.out.println("addListener(" + source + ", " + param + ", " + m + ") invoked...");

//        InvocationHandler handler = new InvocationHandler() {
//            public Object invoke(Object proxy, Method mm, Object[] args) throws Throwable {
//                return m.invoke(param);
//            }
//        };
        InvocationHandler handler = (proxy, mm, args) -> {
            System.out.println("in handler: proxyClass = " + proxy.getClass() + ", Method = " + mm );
            System.out.println("   args = " + Arrays.toString(args));
            return m.invoke(param);
        };

        ActionListener listener = (ActionListener)
                Proxy.newProxyInstance(null, new Class[]{ActionListener.class}, handler);
        Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
        adder.invoke(source, listener);
    }
}
