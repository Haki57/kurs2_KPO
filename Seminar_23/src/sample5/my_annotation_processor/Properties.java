package sample5.my_annotation_processor;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Properties {
    Property[] value();
}
