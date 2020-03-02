package structural.p5_facade;

public interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Square::draw()");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
