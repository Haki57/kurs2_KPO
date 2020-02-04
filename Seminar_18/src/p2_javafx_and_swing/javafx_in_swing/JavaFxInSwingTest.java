package p2_javafx_and_swing.javafx_in_swing;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: investigate threads that are involved in the process ...
 * TODO: play with windows/panels resizing - how it is implemented?
 * TODO: try another solution - could we use Region instead of Group as a scene root ???...
 */
public class JavaFxInSwingTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JavaFxInSwingTest::initAndShowGUI);
    }

    private static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("JavaFX panel in Swing JFrame");
        final JFXPanel fxPanel = new MyFXPanel(); //new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(() -> initFX(fxPanel));
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
    private static Scene createScene() {
        Group root  =  new Group();
        Scene scene  =  new Scene(root, Color.ALICEBLUE);
        MyDrawingCanvas canvas = new MyDrawingCanvas();
        root.getChildren().add(canvas);
        return (scene);
    }
}

class MyDrawingCanvas extends Canvas {

    private List<Point2D> points = new ArrayList<>();
    private Point2D breakPoint = new Point2D(-1, -1);

    MyDrawingCanvas(){
        super(500, 500); //TODO: find - how we can resize it (depending on the frame size)?
//System.out.println(Thread.currentThread() + ": MyDrawingCanvas() invoked.");
        this.setOnMousePressed(event -> {
//System.out.println(Thread.currentThread() + " got event: " + event);
            points.add(new Point2D(event.getX(), event.getY()));
            drawLines();
        });
        this.setOnMouseReleased(event -> {
//System.out.println(Thread.currentThread() + " got event: " + event);
            points.add(breakPoint);
            drawLines();
        });
        this.setOnMouseDragged(event -> {
//System.out.println(Thread.currentThread() + " got event: " + event);
            points.add(new Point2D(event.getX(), event.getY()));
            drawLines();
        });
    }

    void drawLines(){
//System.out.println(Thread.currentThread() + ": drawLines() invoked.");

        GraphicsContext gc = getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(3);

        for(int i = 1; i < points.size(); i++){
            Point2D p0 = points.get(i - 1);
            Point2D p1 = points.get(i);
            if(p0 != breakPoint && p1 != breakPoint )
                gc.strokeLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
        }
    }
}

class MyFXPanel extends JFXPanel implements ComponentListener {

    private MyDrawingCanvas canvas = null;

    MyFXPanel(){
        addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
//System.out.println("componentResized(" + e + ")");
        if ( canvas != null ) {
            final Component component = e.getComponent();
            canvas.setWidth(component.getWidth());
            canvas.setHeight(component.getHeight());
            canvas.drawLines();
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}

    /**
     * Attaches a {@code Scene} object to display in this {@code
     * JFXPanel}. This method can be called either on the event
     * dispatch thread or the JavaFX application thread.
     *
     * @param newScene a scene to display in this {@code JFXpanel}
     * @see EventQueue#isDispatchThread()
     * @see Platform#isFxApplicationThread()
     */
    @Override
    public void setScene(Scene newScene) {
        super.setScene(newScene);
        canvas = (MyDrawingCanvas) ((Group)newScene.getRoot()).getChildren().get(0);
    }
}