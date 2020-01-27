package p5_keyboard;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  TODO: It's better to show JavaSound ... (demo with sources, that plays pretty excellent...)
 */

public class PianoKeyboard {
    public static void main(String[] args) throws Exception {
        new PianoKeyboard();
    }

    private PianoKeyboard() throws MidiUnavailableException {
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        JFrame frame = new JFrame("Test Keyboard: \"Yamaha can do better...\"");
        final MidiChannel channel;
        final int velocity = 64;
        JLayeredPane panel = new JLayeredPane(); // TODO: see - how JLayeredPane works...
        frame.add(panel);
        int maxKeys = 49;
        channel = synthesizer.getChannels()[1];

        int width = 20;
        int height = 120;
        for ( int i = 0; i < maxKeys; i++) {
            JButton b = new JButton();
            b.setBackground(Color.WHITE);
            b.setLocation(i * width, 0);
            b.setSize(width, height);

            final int ja = getNote(i, true);
            b.addActionListener( new ActionListener() {
                     public void actionPerformed(ActionEvent e ) {
                         channel.noteOn(ja, velocity);
                     }
                 }
            );
            panel.add(b, 0, -1);
        }

        int width2 = 16;
        int height2 = 80;
        for (int i = 0; i < maxKeys; i++) {
            int j = i % 7;
            if (j == 2 || j == 6)
                continue;
            JButton b = new JButton();
            b.setBackground(Color.BLACK);
            b.setLocation( i * (width) + (width2 * 3/4), 0);
            b.setSize(width2, height2);

            // TODO: to fix replace (i + 50) with getNote(i, false) below:
//            final int ja = i + 50; // getNote(i, false);
            final int ja = getNote(i, false);
            b.addActionListener( new ActionListener() {
                     public void actionPerformed(ActionEvent e ) {
                         channel.noteOn(ja, velocity);
                     }
                 }
            );
            panel.add(b, 1, -1);
        }

        frame.setSize(1000,150);
        frame.setVisible(true);
    }

    private int getNote(int i, boolean isWhite) {
        int octNumber = i / 7;
        int noteNumber = i % 7;
        int shift = (isWhite)? WHITE_SHIFTS[noteNumber] : BLACK_SHIFTS[noteNumber];
        return  START + octNumber * 12 + shift;
    }

    private static final int START = 24; // that means that Middle C = 60...
    private static final int[] WHITE_SHIFTS = {0, 2, 4, 5, 7, 9, 11};
    private static final int[] BLACK_SHIFTS = {1, 3, 0, 6, 8, 10, 0};
}