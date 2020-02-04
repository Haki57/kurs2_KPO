package p3_javafx_controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 *   http://docs.oracle.com/javafx/2/ui_controls/editor.htm
 */
public class HTMLEditorSample extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("HTMLEditor Sample");
        stage.setWidth(400);
        stage.setHeight(300);
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);

        htmlEditor.setStyle(
        "-fx-font: 12 cambria;"
                + "-fx-border-color: brown; "
                + "-fx-border-style: dotted;"
                + "-fx-border-width: 2;"
        );

        Scene scene = new Scene(htmlEditor);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}