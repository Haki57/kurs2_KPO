package structural.p6_bridge.sample1;

/**
 * We use two abstractions: shape and drawing_API... (both are interfaces)
 */

public class BridgeExample {

    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];

        shapes[0] = new CircleShape(1, 2, 3, new DrawingAPI_implementation1());
        shapes[1] = new CircleShape(5, 7, 11, new DrawingAPI_implementation2());

        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }

}
