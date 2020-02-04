package p5_javafx_fxml.fxml_sample_1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *    Created by user on 09.02.2017.
 */
public class FXMLMenuFrame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_menu_frame.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("FXML Menu Frame");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void handle(ActionEvent event) {
        System.out.println("got event: " + event);
        String menuItemText = ((MenuItem)event.getSource()).getText();
        System.out.println(menuItemText);

        //TODO: think - is that good style to exit javafx application?
//        if (menuItemText.equals("Close"))
//            System.exit(0);

        //See Application javadoc
        if (menuItemText.equals("Close")){
            Platform.exit();
        }
    }
}
