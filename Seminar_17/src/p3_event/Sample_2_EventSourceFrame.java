package p3_event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;

// TODO: see repaint count value printed in the title...

public class Sample_2_EventSourceFrame extends JFrame {
    private static final long serialVersionUID = -3716850109234708647L;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public static void main(String[] args) {
        JFrame f = new Sample_2_EventSourceFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private Sample_2_EventSourceFrame(){
        setTitle("EventSourceTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        final PaintCountPanel p = new PaintCountPanel();
        add(p);
        p.addPropertyChangeListener(new PropertyChangeListener(){
            public void propertyChange(PropertyChangeEvent evt) {
                setTitle("EventSourceTest - " + evt.getNewValue());   // todo: See what's going on in Title ...
            }
        });
    }
}

class PaintCountPanel extends JPanel implements ComponentListener {
    private static final long serialVersionUID = 8526222103493634626L;
    private int paintCount;

    PaintCountPanel(){
        addComponentListener(this);
    }

    public int getPaintCount(){
        return paintCount;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int oldPaintCount = paintCount;
        paintCount++;    // TODO: how to paint this count on the PaintCountPanel itself? Do it...
        firePropertyChangeEvent(new PropertyChangeEvent(this, "paintCount", oldPaintCount, paintCount));
    }
    private void firePropertyChangeEvent(PropertyChangeEvent evt){
        EventListener[] listeners = listenerList.getListeners(PropertyChangeListener.class);
        for(EventListener l : listeners){
            ((PropertyChangeListener)l).propertyChange(evt);
        }
    }

    //TODO: think about threads that could execute the methods:
    public void addPropertyChangeListener(PropertyChangeListener l){
        listenerList.add(PropertyChangeListener.class, l);
    }
    public void removePropertyChangeListener(PropertyChangeListener l){
        listenerList.remove(PropertyChangeListener.class, l);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("componentRisized(" + e + ")");
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println("componentMoved(" + e + ")");
    }

    @Override
    public void componentShown(ComponentEvent e) {
        System.out.println("componentShown(" + e + ")");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println("componentHidden(" + e + ")");
   }
}