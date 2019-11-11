package reflection;

/**
 * Finally, let's mess with the Runtime class which has one private static field
 * for storing the current Runtime instance. This is a sample for wrong Singleton implementation in older JDK(s)...
 *
 * TODO: Read below:
 * All this could have been avoided if the currentRuntime field had been declared final (it was not final in earlier JDKs).
 * Nothing prevents setAccessible(true) to be called on the field (8) but when the set(null, null) method is called,
 * IllegalAccessException is thrown with the message "Field is final".
 *
 * singleton fields should always be declared private static final!!!
 * Moreover, make sure you never grant ReflectPermission and RuntimePermission.accessDeclaredMembers
 * in the java.policy file of your production code.
 */

//TODO: see console...(on JDK 8)! - just change JDK version in the Project settings...
//TODO: see console...(on JDK 9)!
//TODO: see console...(on JDK 10)!
//TODO: see console...(on JDK 11)!


public class ReflectiveAccessTest4 {
    public static void main(String[] args) throws Exception {

        Runtime r = Runtime.getRuntime();
        System.out.println("Before: Runtime.getRuntime() yields " + r);

        Class cl = Class.forName("java.lang.Runtime");
        java.lang.reflect.Field f = cl.getDeclaredField("currentRuntime");
        f.setAccessible(true);
        f.set(null, null);

        r = Runtime.getRuntime();
        System.out.println("After: Runtime.getRuntime() yields " + r);

        r.exec("dir"); //raises NullPointerException!!
    }
}