package p4_layouts;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Example_4_BoxLayout extends JFrame {

    private static final long serialVersionUID = 7684960415038933947L;

    private Example_4_BoxLayout() {
        Container c = getContentPane();
        setBounds(20, 80, 300, 300);
        c.setLayout(new BorderLayout());
        Box row = Box.createHorizontalBox();
        for (int i = 0; i < 4; i++) {
            JButton btn = new JButton("Bt " + i);
            btn.setFont(new Font("Tahoma", Font.BOLD, 10 + i * 2));
            row.add(btn);
        }
        c.add(row, BorderLayout.SOUTH);

        JPanel col = new JPanel();
        col.setLayout( new BoxLayout(col, BoxLayout.Y_AXIS));
        col.setBorder(new TitledBorder(new EtchedBorder(), "Column"));
        for (int i = 0; i < 4; i++) {
            JToggleButton btn = new JToggleButton("Button " + i);
            col.add(btn);
        }
        c.add(col, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        Example_4_BoxLayout frame = new Example_4_BoxLayout();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
