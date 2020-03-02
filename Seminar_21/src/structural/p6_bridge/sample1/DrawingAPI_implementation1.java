package structural.p6_bridge.sample1;

/**
 "ConcreteImplementor" 1
 */
public class DrawingAPI_implementation1 implements DrawingAPI {

    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
    }
}
