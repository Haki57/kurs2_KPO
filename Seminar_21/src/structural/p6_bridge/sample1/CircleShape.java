package structural.p6_bridge.sample1;

/**
 "Refined Abstraction"
 */
public class CircleShape implements Shape {

    private double x, y, radius;
    private DrawingAPI drawingAPI;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.drawingAPI = drawingAPI;
    }
    // Implementation specific
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
    // Abstraction specific
    public void resizeByPercentage(double pct) {
        radius *= pct;
    }
}
