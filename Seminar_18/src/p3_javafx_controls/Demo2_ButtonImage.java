package p3_javafx_controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// TODO: see Schildt book, Part IV, Chaper 35.

public class Demo2_ButtonImage extends Application {

    private Label response;

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }

    // Override the start() method.
    public void start(Stage myStage) {
        // Give the stage a title.
        myStage.setTitle("Use Images with Buttons");
        // Use a FlowPane for the root node. In this case,
        // vertical and horizontal gaps of 10.
        FlowPane rootNode = new FlowPane(10, 10);
        // Center the controls in the scene.
        rootNode.setAlignment(Pos.CENTER);
        // Create a scene.
        Scene myScene = new Scene(rootNode, 250, 450);
        // Set the scene on the stage.
        myStage.setScene(myScene);
        // Create a label.
        response = new Label("Push a Button");
        // Create two image-based buttons.
        Button btnHourglass = new Button("Hourglass",
                new ImageView("file:./Seminar_18/src/p3_javafx_controls/hourglass.png"));
        Button btnAnalogClock = new Button("Analog Clock",
                new ImageView("file:./Seminar_18/src/p3_javafx_controls/analog.png"));

        // Position the text under the image.
        btnHourglass.setContentDisplay(ContentDisplay.TOP);
        btnAnalogClock.setContentDisplay(ContentDisplay.TOP);

        // Handle the action events for the hourglass button.
        btnHourglass.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Hourglass Pressed");
            }
        });

        // Handle the action events for the analog clock button.
        btnAnalogClock.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Analog Clock Pressed");
            }
        });

        // Add the label and buttons to the scene graph.
        rootNode.getChildren().addAll(btnHourglass, btnAnalogClock, response);
        // Show the stage and its scene.
        myStage.show();
    }
}
