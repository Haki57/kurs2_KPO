package p4_layouts;

import javax.swing.*;
import java.awt.*;

public class Example_2_GridLayout extends JFrame {
    private static final long serialVersionUID = 5007188185962700267L;

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public static void main(String[] args){
        JFrame f = new Example_2_GridLayout();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private Example_2_GridLayout(){
        setTitle("GridLayout");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        init();
    }

    private Component b[] = new Component[7];

    private void init() {
        setLayout(new GridLayout(2, 4)); // 2 strings and 4 columns

        for (int i = 0; i < b.length; i++)
            add((b[i] = new JButton("(" + i +  ")")));
    }
}
