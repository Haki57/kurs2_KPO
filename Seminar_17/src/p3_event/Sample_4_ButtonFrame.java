package p3_event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sample_4_ButtonFrame extends JFrame {
    private static final long serialVersionUID = 4391103634276387941L;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public static void main(String[] args){
        Sample_4_ButtonFrame f = new Sample_4_ButtonFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private Sample_4_ButtonFrame(){
        setTitle("ButtonTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ButtonPanel p = new ButtonPanel();
        add(p);
    }
}

class ButtonPanel extends JPanel /*implements ActionListener*/ {
    private static final long serialVersionUID = 1917683814680087286L;

    //TODO: why does it work if the following buttons are not used - as Idea's warnings tell?
    JButton yellowButton = makeButton("Yellow" , Color.YELLOW);
    JButton blueButton = makeButton("Blue", Color.BLUE);
    JButton redButton = makeButton("Red", Color.RED);

//    JButton yellowButton = makeButton("Yellow");
//    JButton blueButton = makeButton("Blue");
//    JButton redButton = makeButton("Red");

    private JButton makeButton(String name, /*final*/ Color c){
        JButton b = new JButton(name);
        add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(c);
            }
        });
//        b.addActionListener(e -> setBackground(c));
        return b;
    }

//    JButton makeButton(String name){
//        JButton b = new JButton(name);
//        add(b);
//        b.addActionListener(this);
//        return b;
//    }

//    public void actionPerformed(ActionEvent e) {
//        final Object eventSource = e.getSource();
//        if(eventSource == yellowButton)
//            setBackground(Color.YELLOW);
//        else if(eventSource == blueButton)
//            setBackground(Color.BLUE);
//        else if(eventSource == redButton)
//            setBackground(Color.RED);
//    }
}