package behavioral.b9_iterator.bits;

import java.util.ArrayList;
import java.util.Iterator;

public class TestClientArrayList {

    public static void main(String[] args) {

        ArrayList<Object> al = new ArrayList<Object>();
        al.add(42);
        al.add("test");
//        al.add(new Double("-12.34")); // direct call to the constructor is deprecated (as of JDK9)
        al.add(Double.parseDouble("-12.34"));

        // explicit usage:
        for(Iterator<Object> iter = al.iterator(); iter.hasNext();)
            System.out.println( iter.next() );

        // implicit usage:
        for(Object o : al)
            System.out.println( o );
    }
}

