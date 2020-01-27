package p3_event;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Sample_3_MulticastFrame extends JFrame {
    private static final long serialVersionUID = -1329989007540277509L;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public static void main(String[] args) {
        JFrame f = new Sample_3_MulticastFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private Sample_3_MulticastFrame(){
        setTitle("MulticastTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(new MulticastPanel());
    }
}

class MulticastPanel extends JPanel {
    private static final long serialVersionUID = 3742843018335239170L;

    MulticastPanel(){
        JButton newButton = new JButton("New");
        add(newButton);
        final JButton closeAllButton = new JButton("Close all");
        add(closeAllButton);

        ActionListener newListener = e -> {
            BlankFrame bf = new BlankFrame(closeAllButton);
            bf.setVisible(true);
        };
        newButton.addActionListener(newListener);

    }
}

class BlankFrame extends JFrame /*implements WindowListener*/{
    private static final long serialVersionUID = -7125610447879603268L;
    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 150;
    private static final int SPACING = 40;
    private static int counter = 0;

    private ActionListener closeListener;
    private final JButton closeButton;

    BlankFrame(final JButton closeButton){
        this.closeButton = closeButton;
        counter++;
        setTitle("Frame " + counter);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocation(SPACING * counter, SPACING * counter);
        closeListener = e -> {
            BlankFrame.this.closeButton.removeActionListener(closeListener);
            dispose();
            counter--;
        };
        closeButton.addActionListener(closeListener);
    }
}