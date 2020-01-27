package p1_frames;

import javax.swing.*;
import java.awt.*;

public class Frame_3_Centered extends JFrame {

//    private static final String ICON_FILENAME = ".\\Seminar_17\\src\\p1_frames\\blue-ball.gif";
    private static final String ICON_FILENAME = "./Seminar_17/src/p1_frames/blue-ball.gif";
    private static final long serialVersionUID = 7770926478522667919L;

    private Frame_3_Centered(){
        // discover screen size:
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        System.out.println("toolkit: " + toolkit);

        Dimension screenSize = toolkit.getScreenSize();
        System.out.println(screenSize);

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // position in screen center:
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        // set title and pictogram icon (java cup icon!):
        Image image = toolkit.getImage(ICON_FILENAME);
        setIconImage(image);

        setTitle("Frame_3_Centered");

//        add(new JPanel());
    }
    public static void main(String[] args){
        JFrame frame = new Frame_3_Centered();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

