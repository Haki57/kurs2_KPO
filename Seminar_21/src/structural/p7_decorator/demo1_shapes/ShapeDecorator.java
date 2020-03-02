package structural.p7_decorator.demo1_shapes;

public abstract class ShapeDecorator implements Shape {      // todo: note - abstract class with no abstract methods...

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
