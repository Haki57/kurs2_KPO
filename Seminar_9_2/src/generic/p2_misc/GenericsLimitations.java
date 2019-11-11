package generic.p2_misc;

import java.util.Collection;

public class GenericsLimitations {
    //TODO: 1. uncomment & show: erasure results in error:
//    void sort( Collection< String > strings ) {
//    // Some implementation over strings heres
//    }
//    void sort( Collection< Number > numbers ) {
//        // Some implementation over numbers here
//    }

    //TODO: 2. We cannot use T as runtime entity:
//    public <T> void action( final T action ) {
//        if( action instanceof T ) {
//            // Do something here
//        }
//    }
//    public <T> void action( final T action ) {
//        if( T.class.isAssignableFrom( Number.class ) ) {
//            // Do something here
//        }
//    }

    //TODO: 3. We cannot use T as array element type for instantiations:
//    public <T> void performAction( final T action ) {
//        T[] actions = new T[0];
//    }
}
