package sample5.my_annotation_processor;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Repeatable(Properties.class)
public @interface Property {
    String name() default "";
    String valueTypeName() default "java.lang.Object";
}
