package p4_layouts;

import javax.swing.*;
import java.awt.*;

// TODO: feel the difference between JToggleButton and JButton...

public class Example_5_BorderGridLayout extends JFrame {
    private static final long serialVersionUID = 7630711288132618365L;

    private Example_5_BorderGridLayout() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new JToggleButton("--1--"), BorderLayout.WEST);
        c.add(new JToggleButton("--2--"), BorderLayout.SOUTH);
        c.add(new JToggleButton("--3--"), BorderLayout.EAST);

        JPanel jPanel = new JPanel();
        c.add(jPanel, BorderLayout.NORTH);
        jPanel.setSize(164, 40);
        jPanel.setLayout(new GridLayout(2, 4));
        for (int i = 0; i < 7; i++)
            jPanel.add(new JButton("" + i));
    }

    public static void main(String[] args) {
        Example_5_BorderGridLayout fr = new Example_5_BorderGridLayout();
        fr.setSize(300, 200);
        fr.setTitle("Border & Grid Layouts Example");
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
