package sample4.source_annotations_tools;

import sample4.source_annotations.ChartBean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

//TODO: see output classes and jar and check ChartBeanBeanIfo presence in the jar...

public class BeanInfoTest {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(ChartBean.class);
            System.out.println("BeanInfo = " + beanInfo);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            System.out.println("BeanInfo shows " + propertyDescriptors.length + " property descriptors");
            printPropertyDescriptors(propertyDescriptors);
        } catch (IntrospectionException ie){
            System.out.println("got exception: " + ie);
        }
    }

    public static void printPropertyDescriptors(PropertyDescriptor[] propertyDescriptors){
        for (int i = 0; i < propertyDescriptors.length; i++){
            System.out.println("["+i+"]: PropertyDescriptor for \"" + propertyDescriptors[i].getName() + "\"");
        }
    }
}
