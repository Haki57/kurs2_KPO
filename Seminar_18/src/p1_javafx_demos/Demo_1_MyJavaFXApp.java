package p1_javafx_demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Arrays;

/*
TODO: read javadocs for javafx.application.Application class...
    Note 1: stage and scene must be constructed in application thread only.
    Constructor and init() are called in launcher thread and cannot be used to construct a stage or scene.

    Nite 2: any changes to the GUI currently displayed must be made from the application thread.
    Events in JavaFX are sent to your program on the application thread (it is a behavior thread, and events are behaviors).
    Therefore, event handlers can be used to interact with the GUI. Method stop() is also called on the application thread.
 */

public class Demo_1_MyJavaFXApp extends Application {

    public Demo_1_MyJavaFXApp(){
System.out.println(Thread.currentThread() + ": <constructor()> invoked...");
    }

    @Override
    public void init() throws Exception {
System.out.println(Thread.currentThread() + ": init() invoked...");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
System.out.println(Thread.currentThread() + ": start(" + primaryStage + ") invoked...");

        primaryStage.setTitle(getClass().getSimpleName());
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(myScene);
        primaryStage.show();

//// Note: while scene is not shown, stop()-method is not called...
//System.out.println(Thread.currentThread() + "... calling stop()...");
//        stop();

    }

    @Override
    public void stop() throws Exception {
System.out.println(Thread.currentThread() + ": stop() invoked...");
        super.stop();
    }

    public static void main(String[] args){
System.out.println(Thread.currentThread() + ": main(" + Arrays.toString(args)+ ") invoked...");
        Application.launch(args);
System.out.println(Thread.currentThread() + ": launch(" + Arrays.toString(args)+ ") performed...");
    }
}
