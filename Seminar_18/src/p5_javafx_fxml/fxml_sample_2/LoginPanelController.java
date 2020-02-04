package p5_javafx_fxml.fxml_sample_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginPanelController {

    public LoginPanelController(){
        System.out.println(this + ": constructor()...");
//        new Throwable().printStackTrace();
        System.out.println("actionTarget = " + actionTarget);
    }

    //TODO: note that the following private instance fields are initialized by means of reflection:
    @FXML
    private Text actionTarget;
    //TODO: see the definition of the @FXML annotation (to be explained at the next lesson(s)):

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField username;
    //TODO: note that this instance method is called by reflection (using its name in fxml-file):

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        System.out.println("" + event);
        Node eventSource = (Node) event.getSource();
System.out.println("eventSource = " + eventSource);
        Parent eventSourceParent = eventSource.getParent();
System.out.println("eventSourceParent = " + eventSourceParent);
        Parent eventSourceGrandparent = eventSourceParent.getParent();
System.out.println("eventSourceGrandParent = " + eventSourceGrandparent);
//TODO: note, that we could traverse the nodes tree up and down to search the required nodes (e.g. by name or by id):
System.out.println(eventSourceGrandparent.getChildrenUnmodifiable());
//TODO: ... but we prefer to use @FXML binding (from fxml to java field (using reflection !!!)...)

        System.out.println("actionTarget = " + actionTarget);
        actionTarget.setText("Sign in button pressed");

        System.out.println("usertname = " + username.getText());
        System.out.println("password = " + passwordField.getText());
    }

}