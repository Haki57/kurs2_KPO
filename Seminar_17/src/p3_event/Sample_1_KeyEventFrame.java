package p3_event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Sample_1_KeyEventFrame extends JFrame implements KeyListener {

    private static final long serialVersionUID = 4205167300769314427L;

    public static void main(String[] args){
        JFrame f = new Sample_1_KeyEventFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    private Sample_1_KeyEventFrame(){
        setTitle("Key event frame...");
        getContentPane().setBackground(Color.GREEN);
        setBounds(10, 20, 100, 100);
        addKeyListener(this);
    }



    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("" + e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("" + e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("" + e);
    }
}
