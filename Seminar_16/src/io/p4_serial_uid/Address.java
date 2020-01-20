package io.p4_serial_uid;

import java.io.Serializable;

/**
 * The serialVersionUID is used as a version control in a Serializable class.
 * If you do not explicitly declare a serialVersionUID, JVM will do it for you automatically, based on various aspects
 * of your Serializable class, as described in the Java(TM) Object Serialization Specification.
 *
 * TODO: Without any plugins: You just need to enable highlight: (Idea v.2016(+))
 * File -> Settings -> Editor -> Inspections -> Java -> Serialization issues ->
 *         Serializable class without 'serialVersionUID' - set flag and click 'OK'.
 * Now, if your class implements Serializable, you will see highlight, and alt+Enter on class name will propose
 *         to generate private static final long serialVersionUID.
 */

public class Address implements Serializable {
    private static final long serialVersionUID = 1L; //-1969878281798472952L;

    private long c = 7;
    private String street;
    private String country;

    public void setStreet(String street){
        this.street = street;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCountry(){
        return this.country;
    }

    @Override
    public String toString() {
        return " Street : " + this.street + " Country : " + this.country + ", c = " + c;
    }
}

