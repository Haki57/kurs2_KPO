package structural.p2_composite.demo1_drawing;

/**
 * Created by user on 15.03.2016.
 */
public class Triangle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color " + fillColor);
    }
}
