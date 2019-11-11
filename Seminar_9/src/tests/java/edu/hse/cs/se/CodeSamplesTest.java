package edu.hse.cs.se;

import org.junit.jupiter.api.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.function.LongSupplier;

class CodeSamplesTest {

    private static final int CALL_COUNTER = 200_000_000;
    private CodeSamples instance;
    private LongSupplier interfaceImpl;

    @BeforeAll
    static void setUpAll(){
        System.out.println("setUpAll() invoked.");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp() invoked.");
        instance = new CodeSamples();
        interfaceImpl = instance;
    }

    @Test
    void testStaticMethodCall() {
        System.out.println("testStaticMethodCall() invoked.");
        long total = 0;
        for (int i = 0; i < CALL_COUNTER; i++){
            long t0 = System.nanoTime();
            long t1 = CodeSamples.staticMethodSample();
            total += (t1 - t0);
        }
        printReport(total);
    }

    @Test
    void testInstanceMethodCall() {
        System.out.println("testInstanceMethodCall() invoked.");
        long total = 0;
        for (int i = 0; i < CALL_COUNTER; i++){
            long t0 = System.nanoTime();
            long t1 = instance.instanceMethodSample();
            total += (t1 - t0);
        }
        printReport(total);
    }

    @Test
    void testInterfaceMethodCall() {
        System.out.println("testInterfaceMethodCall() invoked.");
        long total = 0;
        for (int i = 0; i < CALL_COUNTER; i++){
            long t0 = System.nanoTime();
            long t1 = interfaceImpl.getAsLong();
            total += (t1 - t0);
        }
        printReport(total);
    }

    @Test
    void testStaticCallByReflection() {
        System.out.println("testStaticCallByReflection() invoked.");
        Method staticMethodSample = findMethod("staticMethodSample");
        if (staticMethodSample != null) {
            long total = 0;
            for (int i = 0; i < CALL_COUNTER; i++){
                try {
                    long t0 = System.nanoTime();
                    long t1 = (Long) staticMethodSample.invoke(null); // TODO: note unboxing...
                    total += (t1 - t0);
                } catch (Exception ex) {
                    System.out.println("got exception: " + ex);
                }
            }
            printReport(total);
        } else {
            Assertions.fail("no method to invoke...");
        }
    }

    @Test
    void testInstanceCallByReflection() {
        System.out.println("testInstanceCallByReflection() invoked.");
        Method instanceMethodSample = findMethod("instanceMethodSample");
        if (instanceMethodSample != null) {
            long total = 0;
            for (int i = 0; i < CALL_COUNTER; i++){
                try {
                    long t0 = System.nanoTime();
                    long t1 = (Long) instanceMethodSample.invoke(instance); // TODO: note unboxing...
                    total += (t1 - t0);
                } catch (Exception ex) {
                    System.out.println("got exception: " + ex);
                }
            }
            printReport(total);
        } else {
            Assertions.fail("no method to invoke...");
        }
    }

    //TODO: write tests using Method Handles...
    @Test
    void testStaticCallByMethodHandle() {
        System.out.println("testStaticCallByMethodHandle() invoked.");
        Method staticMethodSample = findMethod("staticMethodSample");
        if (staticMethodSample != null) {
            MethodHandle staticMethodHandle = getMethodHandle(staticMethodSample);
            if (staticMethodHandle == null)
                Assertions.fail("no method handle ...");
            long total = 0;
            for (int i = 0; i < CALL_COUNTER; i++){
                try {
                    long t0 = System.nanoTime();
                    long t1 = (Long) staticMethodHandle.invoke(); // TODO: note unboxing...
                    total += (t1 - t0);
                } catch (Throwable th) {
                    System.out.println("got exception: " + th);
                }
            }
            printReport(total);
        } else {
            Assertions.fail("no method to invoke...");
        }
    }

    @Test
    void testInstanceCallByMethodHandle() {
        System.out.println("testInstanceCallByMethodHandle() invoked.");
        Method instanceMethodSample = findMethod("instanceMethodSample");
        if (instanceMethodSample != null) {
            MethodHandle instanceMethodHandle = getMethodHandle(instanceMethodSample);
            if (instanceMethodHandle == null)
                Assertions.fail("no method handle ...");
            long total = 0;
            for (int i = 0; i < CALL_COUNTER; i++){
                try {
                    long t0 = System.nanoTime();
                    long t1 = (Long) instanceMethodHandle.invoke(instance); // TODO: note unboxing...
                    total += (t1 - t0);
                } catch (Throwable th) {
                    System.out.println("got exception: " + th);
                }
            }
            printReport(total);
        } else {
            Assertions.fail("no method to invoke...");
        }
    }

    private MethodHandle getMethodHandle(Method method) {
        MethodHandle result = null;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            result = lookup.unreflect(method);
        } catch (IllegalAccessException iae) {
            System.out.println("got exception: " + iae);
        }
        return result;
    }

    private Method findMethod(String methodName) {
        Method result = null;
        try {
            result = CodeSamples.class.getDeclaredMethod(methodName);
        } catch (NoSuchMethodException nsme) {
            System.out.println("got exception: " + nsme);
        }
        return result;
    }

    private void printReport(long total) {
        System.out.println("CALL_COUNTER = " + CALL_COUNTER + "; total = " + total + " nsec => One invocation & return time = " + ((double)total) / CALL_COUNTER );
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown() invoked.");
        instance = null;
        interfaceImpl = null;
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("tearDownAll() invoked.");
    }
}