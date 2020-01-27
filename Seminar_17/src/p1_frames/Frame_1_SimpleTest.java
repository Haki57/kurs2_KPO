package p1_frames;

import javax.swing.*;

public class Frame_1_SimpleTest extends JFrame {

    private static final long serialVersionUID = -6965988362584597812L;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private Frame_1_SimpleTest(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);                                      //todo: show uncommented...
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        setTitle("My First Frame");
        setTitle("Мой первый Frame");

        add(new JButton("Моя любимая кнопка - не трогать!!!"));
        setVisible(true);
    }

    public static void main(String[] args){
        JFrame frame = new Frame_1_SimpleTest();
System.out.println("frame: " + frame);

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setUndecorated(true);
//        frame.setTitle("My First Frame");
//        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        frame.setVisible(true);
         System.out.println("FINISHING MAIN");
    }
}



