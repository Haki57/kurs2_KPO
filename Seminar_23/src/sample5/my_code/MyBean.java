package sample5.my_code;

import sample5.my_annotation_processor.Properties;
import sample5.my_annotation_processor.Property;

@Properties(
    {
        @Property(name = "floatValue", valueTypeName = "float"),
        @Property(name = "stringValue", valueTypeName = "java.lang.String"),
        @Property(name = "objectValue", valueTypeName = "java.lang.Object")
    }
)
public class MyBean implements java.io.Serializable {
    private static final long serialVersionUID = 3166826570003086340L;
}
