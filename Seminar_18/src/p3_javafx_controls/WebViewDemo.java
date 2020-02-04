package p3_javafx_controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

//TODO: see also Tutorial at https://o7planning.org/ru/11151/javafx-webview-and-webengine-tutorial

public class WebViewDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
//        engine.load("http://localhost:8080/");
        engine.load("http://www.hse.ru");
        root.getChildren().add(view);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        Application.launch(args);
    }
}
