package p2_javafx_and_swing.swing_in_javafx;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * TODO: test an ability to embed awt.Panel into JavaFX application...
 * TODO: investigate window resizing (how it is implemented?)...
 *
 */
public class SwingInJavaFXTest extends Application {

    @FXML
    protected SwingNode swingNode;

    @Override
    public void start(Stage stage) throws Exception {
//        URL url = getClass().getResource("testSwingInJavaFX.fxml");
//System.out.println("url = " + url);
//        Parent root = FXMLLoader.load(url);
        Parent root = FXMLLoader.load(getClass().getResource("testSwingInJavaFX.fxml"));
        swingNode = (SwingNode) root.lookup("#swingNode");
//System.out.println("swingNode = " + swingNode);
        swingNode.setContent(new MySwingComponent());
//System.out.println("swingNode.getContent() = " + swingNode.getContent());

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Swing JPanel in JavaFX Scene...");
        stage.setScene(scene);
        stage.show();
    }
}

class MySwingComponent extends JPanel implements ComponentListener {

    private static final Point breakPoint = new Point(-1, -1);
    private java.util.List<Point> points = new ArrayList<>();
    private Stroke stroke = new BasicStroke(3.F); // 3.0F

    MySwingComponent(){
        setBackground(Color.white);
        MouseAdapter ma = new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                points.add(e.getPoint());
                repaint();
            }
            public void mouseReleased(MouseEvent e){
                points.add(breakPoint);
                repaint();
            }
            public void mouseDragged(MouseEvent e){
                points.add(e.getPoint());
                repaint();
            }
        };
        this.addMouseListener(ma);
        this.addMouseMotionListener(ma);
        this.addComponentListener(this);
        repaint();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}

    public void paintComponent(Graphics g){
        super.paintComponent(g);
//System.out.println("paintComponent()...");
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(stroke);
        g2.setPaint(Color.BLACK);
        for(int i = 1; i < points.size(); i++){
            Point p0 = points.get(i - 1);
            Point p1 = points.get(i);
            if(p0 != breakPoint && p1 != breakPoint )
                g2.drawLine(p0.x, p0.y, p1.x, p1.y);
        }
    }
}