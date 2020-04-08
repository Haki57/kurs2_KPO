package sample4.source_annotations_tools;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface PropertyForEditor {
    String editor() default "";
}
