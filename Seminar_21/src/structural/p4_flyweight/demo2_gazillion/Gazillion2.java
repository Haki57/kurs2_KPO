package structural.p4_flyweight.demo2_gazillion;

public class Gazillion2 {

    private int row;

    public Gazillion2( int theRow ) {
        row = theRow;
        System.out.println( "Actual ctor: " + row );
    }

    void report( int theCol ) {
        System.out.print( " " + row + theCol );
    }
}
