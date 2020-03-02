package structural.p2_composite.demo1_drawing;

public class TestCompositionPattern {

    public static void main(String[] args) {
        Shape tri2 = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();

        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);
        drawing.draw("Red");

        drawing.clear();
        drawing.add(tri2);
        drawing.add(cir);
        drawing.draw("Green");
    }
}

