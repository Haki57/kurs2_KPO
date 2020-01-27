package p2_drawing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class DrawTest_4 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(ImageFrame::new);

//        EventQueue.invokeLater(new Runnable(){
//            public void run() {
//               ImageFrame frame = new ImageFrame();
//            }
//        });
//        ImageFrame frame = new ImageFrame();
    }
}

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame {
    private static final long serialVersionUID = 5436737619092307080L;
//    public static final int DEFAULT_WIDTH = 300;
//    public static final int DEFAULT_HEIGHT = 200;


    private static final String RESOURCE_NAME_1 = "./p2_drawing/portrait_small.jpg";
    private static final String RESOURCE_NAME_2 = "./p2_drawing/portrait_small.jpg";
    private static final String RESOURCE_NAME_3 = "portrait_small.jpg";
    private static final String RESOURCE_NAME_4 = "./Seminar_17/src/p2_drawing/portrait_small.jpg";


    ImageFrame() {
//System.out.println("ImageFrame()...");
        setTitle("DrawTest_4");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setUndecorated(true);
        setVisible(true);

//System.out.println("Frame.size: " + this.getSize());
//System.out.println("Frame.insets: " + this.getInsets());
////System.out.println("contentPane.layout = " + getContentPane().getLayout());
//System.out.println("contentPane.insets: " + this.getContentPane().getInsets());
//System.out.println("contentPane.size: " + this.getContentPane().getSize());

//        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        // add component to frame
//        ImageComponent component = new ImageComponent();
//        add(component);

        //todo: how we can know the size of title bar, etc.?
        Image im = getImage();

        Insets insets = getInsets();
System.out.println("insets = " + insets);

        int frameWidth = im.getWidth(this) + insets.left + insets.right;
        int frameHeight = im.getHeight(this) + insets.top + insets.bottom;

//        int frameWidth = im.getWidth(this);
//        int frameHeight = im.getHeight(this);

        setSize(frameWidth, frameHeight);

        ImageComponent imageComponent = new ImageComponent(im);
        getContentPane().add(imageComponent);
    }

    private static Image getImage(){
        Image result = null;
        try {
            // # 1:
//            InputStream is = ImageFrame.class.getClassLoader().getResourceAsStream(RESOURCE_NAME_1);
//System.out.println("is = " + is);
//            assert is != null;
//            result = ImageIO.read(is);

            // # 2:
//            URL url = ImageFrame.class.getClassLoader().getResource(RESOURCE_NAME_2);
//System.out.println("url = " + url);
//            result = ImageIO.read(Objects.requireNonNull(url));

            // # 3:
//            result = ImageIO.read(ImageFrame.class.getResource(RESOURCE_NAME_3));

            // # 4:
            result = ImageIO.read(new File(RESOURCE_NAME_4));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

/**
 * A component that displays a tiled image
 */
class ImageComponent extends JComponent {
    private static final long serialVersionUID = -5044799659016115767L;

    private Image image;
    private int imageWidth;
    private int imageHeight;

//    public ImageComponent() {
//        this(ImageFrame.getImage());
//    }

    ImageComponent(Image image){
        this.image = image;
        imageWidth = image.getWidth(this);
        imageHeight = image.getHeight(this);
    }

    public void paintComponent(Graphics g) {     //todo: resize window & see...
        if (image == null) return;

        // draw the image in the upper-left corner
        g.drawImage(image, 0, 0, null);

        // tile the image across the component
        for (int i = 0; i * imageWidth <= getWidth(); i++)
            for (int j = 0; j * imageHeight <= getHeight(); j++)
                if (i + j > 0)
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
    }
}

