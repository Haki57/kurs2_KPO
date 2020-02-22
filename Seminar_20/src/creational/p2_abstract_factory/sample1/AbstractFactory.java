package creational.p2_abstract_factory.sample1;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
}
