package collections;

import java.util.*;

public class CollectionFilter<T> {

    public static void main(String[] args) {
        Collection<?> c = createCollection();
        System.out.println("collection = " + c);
        Collection<?> filtered = filter(c);
        System.out.println("_filtered_ = " + filtered);
    }

    private static Collection<?> createCollection(){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            list.add(random.nextInt());
        }
        return list;
    }

    //TODO: note - that is the old fashioned style implementation:
//    private static Collection<?> filter(Collection<?> c){
//        for (Iterator<?> i = c.iterator(); i.hasNext(); ){
//            if (!cond(i.next()))
//                i.remove();
//        }
//        return c;
//    }

    // TODO: that is a modern ('more functional") style (but look at the removeIf()-method implementation...)
    private static Collection<?> filter(Collection<?> c){
        c.removeIf(o -> !cond(o));
//        c.removeIf(CollectionFilter::cond);
        return c;
    }

    //TODO: note generic type T usage in static method declaration - it can be done having separate generic method:
    //TODO: note -  but it cannot be done without separate generic type parameter in the method declaration:
    private static <T> boolean cond(T o){
        return o.hashCode() % 2 == 0;
    }
//    private static boolean anotherCond(T o){
//        return o.hashCode() % 2 == 0;
//    }
}
