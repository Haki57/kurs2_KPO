package collections;

import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[] args) {
//        TreeSet<Number> s = new TreeSet<>();
        TreeSet s = new TreeSet();
        s.add(1);
        s.add(99.9);
//        s.add(99.9);
        s.add(96.9);
        for (int i = 0; i < s.size(); i++) {
            System.out.print(s.pollFirst() + " ");
        }

    }
}
