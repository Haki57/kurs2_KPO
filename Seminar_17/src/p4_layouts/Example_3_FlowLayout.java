package p4_layouts;

import javax.swing.*;
import java.awt.*;

public class Example_3_FlowLayout extends JFrame {
    private static final long serialVersionUID = -1514769969204101824L;

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    private Component c[] = new Component[9];

    public static void main(String[] args){
        JFrame f = new Example_3_FlowLayout();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private Example_3_FlowLayout(){
        setTitle("Flow Layout example");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        init();
    }

    private void init() {
        String[] msg = { "Label 1", "Label 2", "Label 3" };
        String[] str = { "Button 1", "Button 2", "Button 3" };
        String[] txt = {"Text 1", "Text 2", "Text 3"};
//Setting layout manager:
        setLayout(new FlowLayout());
        setBackground(Color.gray);
        setForeground(Color.getHSBColor(1f, 1f, 1f));
        for (int i = 0; i < c.length/3; i++) {
            c[i] = new JButton(str[i]);
            add(c[i]);
            c[i + 3] = new JLabel(msg[i]);
            add(c[i + 3]);
            c[i+6] = new JTextField(txt[i]);
            add(c[i + 6]);
        }
        setSize(450, 150);
    }
}
