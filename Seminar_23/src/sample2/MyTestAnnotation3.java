package sample2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTestAnnotation3 {
    String stringHello = "hello";
    long longData() default 0;
    String stringData() default stringHello;
}
