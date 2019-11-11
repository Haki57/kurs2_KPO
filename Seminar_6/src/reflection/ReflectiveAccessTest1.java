package reflection;

/**
 *  Hack any Java class using Reflection
 *
 *  Do you think private methods are really only accessible from within the declaring class?
 *  Do you think that a private field can only be modified from within the declaring class? No?
 *
 *  For instance, let's look at the following example where we successfully retrieve a private password
 *  from another class:
 */

class A {
    private static String getPassword() {
        return "someTopSecret";
    }
}

public class ReflectiveAccessTest1 {

    public static void main(String[] args) throws Exception {
//        System.setSecurityManager(new SecurityManager()); //TODO: comment/uncomment ...

        Class cl = Class.forName("reflection.A");
        java.lang.reflect.Method[] m = cl.getDeclaredMethods();
        m[0].setAccessible(true);
        String password = (String) m[0].invoke(null, (Object[])null);
        System.out.println("I've got it: " + password);
    }
}
