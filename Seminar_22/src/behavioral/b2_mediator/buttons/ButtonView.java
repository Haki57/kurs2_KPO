package behavioral.b2_mediator.buttons;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonView extends JButton implements Command {

    Mediator mediator;

    public ButtonView(ActionListener listener, Mediator mediator){
        super("View");
        addActionListener(listener);
        this.mediator = mediator;
        mediator.registerView(this);
    }
    public void execute() {
        mediator.view();
    }
}
