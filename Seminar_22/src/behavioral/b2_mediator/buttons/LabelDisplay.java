package behavioral.b2_mediator.buttons;

import javax.swing.*;
import java.awt.*;

public class LabelDisplay extends JLabel {

    Mediator med;

    LabelDisplay(Mediator m) {
        super("Just start...");
        med = m;
        med.registerDisplay(this);
        setFont(new Font("Arial", Font.BOLD, 24));
    }
}
