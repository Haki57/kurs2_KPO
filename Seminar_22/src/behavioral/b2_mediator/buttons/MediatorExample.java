package behavioral.b2_mediator.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MediatorExample extends JFrame implements ActionListener {

    Mediator mediator = new Mediator();

    public MediatorExample() {
        JPanel p = new JPanel();
        p.add(new ButtonView(this, mediator));
        p.add(new ButtonBook(this, mediator));
        p.add(new ButtonSearch(this, mediator));
        getContentPane().add(new LabelDisplay(mediator), BorderLayout.NORTH);
        getContentPane().add(p, BorderLayout.SOUTH);
        setTitle("Mediator Example");
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Command) {
            Command c = (Command)e.getSource();
            c.execute();
        }
    }
    public static void main(String[] args) {
        new MediatorExample();
    }
}
