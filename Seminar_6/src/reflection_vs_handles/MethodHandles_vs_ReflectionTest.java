package reflection_vs_handles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/*
TODO: note that invoke through method handle works several times faster than it is done by reflection.
TODO: note that invoke through method handle works very fast comparing with direct access to the method...(!)
  - it is only 20% slower... while reflection invoke is ~9.5 times slower than direct access...
TODO: we can transform java.lang.reflect.Method into the MethodHandle:  see unreflect()-method usage below.
 */

public class MethodHandles_vs_ReflectionTest {

    private static final int COUNTER_VALUE = 1_000_000;
    private TestBean testBean;

    public static void main(String[] args) throws Throwable {
        MethodHandles_vs_ReflectionTest test = new MethodHandles_vs_ReflectionTest();
        test.init();
        test.testDirectAccess();
        test.testReflectionAccess();
        test.testMethodHandleAccess();
    }

    private void init(){
        testBean = new TestBean();
    }

    private void testDirectAccess(){
        testDirectAccessInt();
        testDirectAccessStr();
    }

    private void testDirectAccessInt(){
        int v = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < COUNTER_VALUE; i++){
            testBean.setIntValue(i);
            v = testBean.getIntValue();
        }
        long t1 = System.nanoTime();
        System.out.println("T(directAccess) = " + (t1 - t0) + "; v = " + v);
    }
    private void testDirectAccessStr(){
        String v = "";
        long t0 = System.nanoTime();
        for (int i = 0; i < COUNTER_VALUE; i++){
            testBean.setStringValue("AAAA");
            v = testBean.getStringValue();
        }
        long t1 = System.nanoTime();
        System.out.println("T(directAccess) = " + (t1 - t0) + "; v = " + v);
    }

    private void testReflectionAccess() throws Exception {
        Method intGetter = TestBean.class.getDeclaredMethod("getIntValue");
System.out.println(intGetter);
        Method intSetter = TestBean.class.getDeclaredMethod("setIntValue", int.class);
System.out.println(intSetter);

final MethodHandles.Lookup lookup = MethodHandles.lookup();
MethodHandle intGetterMH = lookup.unreflect(intGetter);
System.out.println("unreflect: " + intGetterMH);
MethodHandle intSetterMH = lookup.unreflect(intSetter);
System.out.println("unreflect: " + intSetterMH);

        Method stringGetter = TestBean.class.getDeclaredMethod("getStringValue");
System.out.println(stringGetter);
        Method stringSetter = TestBean.class.getDeclaredMethod("setStringValue", String.class);
System.out.println(stringSetter);

MethodHandle strGetterMH = lookup.unreflect(stringGetter);
System.out.println("unreflect: " + strGetterMH);
MethodHandle strSetterMH = lookup.unreflect(stringSetter);
System.out.println("unreflect: " + strSetterMH);

        measureReflectionInt(intSetter, intGetter);
        measureReflectionString(stringSetter, stringGetter);
    }

    private void testMethodHandleAccess() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType mtIntGetter = MethodType.methodType(int.class);
        MethodHandle intGetterMH = lookup.findVirtual(TestBean.class, "getIntValue", mtIntGetter);
System.out.println(intGetterMH);
        MethodType mtIntSetter = MethodType.methodType(void.class, int.class);
        MethodHandle intSetterMH = lookup.findVirtual(TestBean.class, "setIntValue", mtIntSetter);
System.out.println(intSetterMH);

        MethodType mtStrGetter = MethodType.methodType(String.class);
        MethodHandle strGetterMH = lookup.findVirtual(TestBean.class, "getStringValue", mtStrGetter);
System.out.println(strGetterMH);
        MethodType mtStrSetter = MethodType.methodType(void.class, String.class);
        MethodHandle strSetterMH = lookup.findVirtual(TestBean.class, "setStringValue", mtStrSetter);
System.out.println(strSetterMH);

        measureMethodHandleInt(intSetterMH, intGetterMH);
        measureMethodHandleString(strSetterMH, strGetterMH);
    }

    private void measureReflectionInt(Method setter, Method getter) throws Exception {
        long t0 = System.nanoTime();
        for (int i = 0; i < COUNTER_VALUE; i++){
            setter.invoke(testBean, i);
            getter.invoke(testBean);
        }
        long t1 = System.nanoTime();
        System.out.println("T(reflection) = " + (t1 - t0));
    }
    private void measureReflectionString(Method setter, Method getter) throws Exception {
        long t0 = System.nanoTime();
        for (int i = 0; i < COUNTER_VALUE; i++){
            setter.invoke(testBean, "BBBB");
            getter.invoke(testBean);
        }
        long t1 = System.nanoTime();
        System.out.println("T(reflection) = " + (t1 - t0));
    }

    private void measureMethodHandleInt(MethodHandle setter, MethodHandle getter) throws Throwable {
        long t0 = System.nanoTime();
        for (int i = 0; i < COUNTER_VALUE; i++){
            setter.invoke(testBean, i);
            getter.invoke(testBean);
        }
        long t1 = System.nanoTime();
        System.out.println("T(methodHandle) = " + (t1 - t0));
    }
    private void measureMethodHandleString(MethodHandle setter, MethodHandle getter) throws Throwable {
        long t0 = System.nanoTime();
        for (int i = 0; i < COUNTER_VALUE; i++){
            setter.invoke(testBean, "AAAA");
            getter.invoke(testBean);
        }
        long t1 = System.nanoTime();
        System.out.println("T(methodHandle) = " + (t1 - t0));
    }
}

