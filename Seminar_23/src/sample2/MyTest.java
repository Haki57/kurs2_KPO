package sample2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyTest {

    public static void main(String[] args){
        try {
            Class<?> a1class = Class.forName("sample2.MyTestAnnotation1");
            //TODO: note - a1class is the 'normal' java interface (not an 'annotation' interface)...
            System.out.println("a1class = " + a1class);

            Class<?> a2class = Class.forName("sample2.MyTestAnnotation2");
            System.out.println("a2class = " + a2class);
            Class<?> a3class = Class.forName("sample2.MyTestAnnotation3");
            System.out.println("a3class = " + a3class);

            System.out.println("a3class.getSuperclass() = " + a3class.getSuperclass());
            System.out.println("a3class.getInterfaces() = " + Arrays.toString(a3class.getInterfaces()));

            // test annotation usage:
            Class<?> c = Class.forName("sample2.MyClass");
            Annotation[] annotations = c.getAnnotations();
            System.out.println(Arrays.toString(annotations)); //todo: why there is no annotation1, annotation2?
            for (Annotation a : annotations){
                System.out.println("a.getClass() = " + a.getClass());
            }

            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods) {
                annotations = m.getDeclaredAnnotations();
                System.out.println("method: " + m);
                System.out.println("annotations: " + Arrays.toString(annotations));
            }

        } catch (Exception ex){
            System.out.println("got exception: " + ex);
        }
    }
}
