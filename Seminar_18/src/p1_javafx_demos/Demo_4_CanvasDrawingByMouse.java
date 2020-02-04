package p1_javafx_demos;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.ArrayList;

//TODO: compare this class with similar demo from the Seminar_18 (on awt/swing)... What/where is the difference?

public class Demo_4_CanvasDrawingByMouse extends Application {

    private static final Point2D breakPoint = new Point2D(-1, -1);
    private java.util.List<Point2D> points = new ArrayList<>();
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
System.out.println(Thread.currentThread() + ": start(" + primaryStage + ") invoked...");
        setUserAgentStylesheet(STYLESHEET_MODENA);

        primaryStage.setTitle("Drawing Operations Test");

        Group root = new Group();
        canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        canvas.setOnMousePressed(event -> {
System.out.println(Thread.currentThread() + ": event = " + event);
            points.add(new Point2D(event.getX(), event.getY()));
            drawLines();
        });
        canvas.setOnMouseReleased(event -> {
System.out.println(Thread.currentThread() + ": event = " + event);
            points.add(breakPoint);
            drawLines();
        });
        canvas.setOnMouseDragged(event -> {
System.out.println(Thread.currentThread() + ": event = " + event);
            points.add(new Point2D(event.getX(), event.getY()));
            drawLines();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawLines(){
System.out.println(Thread.currentThread() + "drawLines()...");
        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setStroke(javafx.scene.paint.Color.BLUE);
        gc.setLineWidth(3);

        //TODO: what is the difference with the following (uncommented) code?
//        for(int i = 1; i < points.size(); i++){
//            Point2D p0 = points.get(i - 1);
//            Point2D p1 = points.get(i);
//            if(p0 != breakPoint && p1 != breakPoint )
//                gc.strokeLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
//        }

        // TODO: explain; which variant is better and why... (better - means there is some criteria...that should be linked with a goal...)
        int size = points.size();
        if(size >= 2) {
            Point2D p1 = points.get(size - 1);
            Point2D p0 = points.get(size - 2);
            if (p0 != breakPoint && p1 != breakPoint)
                gc.strokeLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread() + ": stop() invoked...");
        super.stop();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + ": main() invoked...");
        launch(args);
    }
}
