package structural.p4_flyweight.demo1_drawing;

import java.awt.*;

public interface Shape {
    public void draw(Graphics g, int x, int y, int width, int height, Color color);
}
