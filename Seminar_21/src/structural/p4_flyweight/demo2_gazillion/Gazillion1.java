package structural.p4_flyweight.demo2_gazillion;

public class Gazillion1 {

    public static int num = 0;
    private int row, col;

    public Gazillion1( int maxPerRow ) {
        row = num / maxPerRow;
        col = num % maxPerRow;
        num++;
    }

    void report() {
        System.out.print( " " + row + col );
    }
}
