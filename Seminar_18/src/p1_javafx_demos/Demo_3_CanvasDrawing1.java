package p1_javafx_demos;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

//TODO: note the difference comparing with awt/swing: how the whole work is divided among threads ...

public class Demo_3_CanvasDrawing1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println("thread = " + Thread.currentThread() + ": start(" + primaryStage + ") invoked.");
//        setUserAgentStylesheet(STYLESHEET_MODENA);

        primaryStage.setTitle("Drawing Operations Test");

        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Draws a series of basic shapes on the specified GraphicsContext.
     * @param gc The GraphicsContext object to draw on
     */
    private void drawShapes(GraphicsContext gc) {
System.out.println(Thread.currentThread()+ ": drawShapes(" + gc + ")");
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);

        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);

        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);

        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);

        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);

        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);

        gc.fillPolygon(new double[]{10, 40, 10, 40}, new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90}, new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140}, new double[]{210, 210, 240, 240}, 4);
    }
    
    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread() + ": stop() invoked...");
        super.stop();
    }

    public static void main(String[] args) {
        System.out.println("thread = " + Thread.currentThread());
        launch(args);
    }

}
