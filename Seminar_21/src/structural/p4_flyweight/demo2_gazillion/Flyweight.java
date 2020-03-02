package structural.p4_flyweight.demo2_gazillion;

/*
        Introducing Flyweight means that we remove the non-shareable state from
        the class, and making the client supply it when needed. This places more
        responsibility on the client, but, considerably fewer instances of the
        Flyweight class are now created. Sharing of these instances is facilitated by
        introducing a Factory class that maintains a pool of existing Flyweights with a
        reusable state.

        In the following example, the "row" state is considered
        shareable (within each row anyways), and the "col" state has been
        externalized (it is supplied by the client when report() is called).

        When Flyweight is executed we generate, from a client perspective the same
        (excessive) amount of instances but in reality we only generate one instance
        per row and reuse that instance several times. This is indicated in the output
        below with the text “Actual instance no. x”:
//*/

public class Flyweight {

    public static final int ROWS = 6, COLS = 10;

    public static void main( String[] args ) {

        FlyweightFactory theFactory = new FlyweightFactory( ROWS );

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++)
                theFactory.getFlyweight( i ).report( j );
            System.out.println();
        }
    }
}
