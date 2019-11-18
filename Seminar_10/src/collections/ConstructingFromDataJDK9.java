package collections;

import java.util.*;

//TODO: new population related methods were added starting from JDK9...

public class ConstructingFromDataJDK9 {
    public static void main(String[] args) {
        // 1. List<E> factory:
        List<Integer> emptyImmutableList = List.of(); // staring from JDK9
//        emptyImmutableList.add(7); // results in UnsupportedOperationException...
        List<Integer> immutableList = List.of(0, 1, 2, 3, 4, 5);
System.out.println("immutableList = " + immutableList);
        List<Integer> mutableList = new ArrayList<>(immutableList);
System.out.println("mutableList = " + mutableList);

        // 2. Set<E> factory methods:
        Set<Integer> emptyImmutableSet = Set.of();
//        emptyImmutableSet.add(7);
        Set<Integer> immutableSet = Set.of(0, 1, 2, 3, 4, 5); // may not be ordered...
System.out.println("immutableSet = " + immutableSet);
        Set<Integer> mutableSet = new HashSet<>(immutableSet);
System.out.println("mutableSet = " + mutableSet);

        // 3. Map<K, V> factory:
        Map<Integer, Integer> emptyImmutableMap = Map.of();
        Map<Integer, Integer> immutableMap = Map.of(1, 2, 3, 4);
System.out.println("immutableMap = " + immutableMap);
        Map<Integer, Integer> mutableMap = new HashMap<>(immutableMap);
System.out.println("mutableMap = " + mutableMap);
    }
}
//*/