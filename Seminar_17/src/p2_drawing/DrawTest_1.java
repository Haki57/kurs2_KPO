package p2_drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawTest_1 {

    public static void main(String[] args) {
        //todo: comment & uncomment the following variants to see the thread in DrawFrame - constructor...
      EventQueue.invokeLater(() -> {
         DrawFrame frame = new DrawFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
      });

//        DrawFrame frame = new DrawFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setVisible(true);
    }
}

/**
 * A frame that contains a panel with drawings
 */
class DrawFrame extends JFrame {
    private static final long serialVersionUID = 8902968221134508405L;

    DrawFrame() {
System.out.println("DrawFrame() invoked.\r\n thread = " + Thread.currentThread());
        setTitle("DrawTest_1");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // add panel to frame
        DrawComponent component = new DrawComponent();
        add(component);
    }

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
}

/**
 * A component that displays rectangles and ellipses.
 */
class DrawComponent extends JComponent {
    private static final long serialVersionUID = 285474212506736864L;

    public void paintComponent(Graphics g) {
System.out.println("paintComponent(" + g + ") invoked. \r\n thread = " + Thread.currentThread());

        Graphics2D g2 = (Graphics2D) g;  // todo: explain - why the cast is needed...

        // draw a rectangle
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        // draw the enclosed ellipse
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        // draw a diagonal line
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        // draw a circle with the same center
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }
}
