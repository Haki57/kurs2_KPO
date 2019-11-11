package reflection_vs_handles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class MethodHandlesDemo {
    public static void main(String[] args) {
        MethodHandle methodHandle1 = findGetterHandleAsVirtualMethod();
        System.out.println(methodHandle1);
        MethodHandle methodHandle2 = findFieldGetterHandle();
        System.out.println(methodHandle2);

        TestBean testBean = new TestBean();

        try {
            testBean.setIntValue(7);
            int value = (Integer) methodHandle1.invoke(testBean); // see getter invoked...
            System.out.println(value);

            testBean.setIntValue(8);
            value = (Integer) methodHandle2.invoke(testBean); // see "direct" field access; we cannot access private field...
            System.out.println(value);

            // but:
            Method method = TestBean.class.getDeclaredMethod("readPrivate");
            method.setAccessible(true);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle methodHandle = lookup.unreflect(method);
            testBean.setStringValue("when prohibited but desired then allowed...");
            String s = (String) methodHandle.invoke(testBean);
            System.out.println("got a string: " + s);

        } catch (Throwable th) {
            System.out.println("got throwable: " + th);
        }
    }

    private static MethodHandle findGetterHandleAsVirtualMethod() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = null;
        MethodType intGetterMethodType = MethodType.methodType(int.class); // no arguments method, just the return type...
        try {
            methodHandle = lookup.findVirtual( TestBean.class, "getIntValue", intGetterMethodType);
        } catch (Exception ex) {
            System.out.println("got exception: " + ex);
        }
        return methodHandle;
    }

    private static MethodHandle findFieldGetterHandle(){
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = null;
        try {
            methodHandle = lookup.findGetter(TestBean.class, "intValue", int.class); // property name...
        } catch (Exception ex) {
            System.out.println("got exception: " + ex);
        }
        return methodHandle;
    }
}
