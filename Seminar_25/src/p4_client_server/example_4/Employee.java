package p4_client_server.example_4;

import java.io.Serializable;

/**
 *  TODO:  Java bean ...
 */
public class Employee implements Serializable {
    private int id;
    private String name;
    private double salary;

    public Employee(){}

    public int getId(){return id;}
    public void setId(int newValue) {id = newValue;}

    public String getName(){return name;}
    public void setName(String newValue) {name = newValue;}

    public double getSalary(){return salary;}
    public void setSalary(double newValue) {salary = newValue;}
}
