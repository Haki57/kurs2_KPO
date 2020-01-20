package streams.p4_miscellenious;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static streams.p1_creation.StreamCreationDemo.show;

public class SomeStreamsMethodsDemo {
    public static void main(String[] args) {
        // 1. distinct:
        Stream<String> uniqueWords = Stream.of("one", "two", "three", "one").distinct();
        show("unique", uniqueWords);

        // 2. sorted
        Stream<Integer> sorted = Stream.of(1, 3, 2, 5, 8, 20 ,7).sorted();
        show("sorted", sorted);

        Stream<String> sortedStrings = Stream.of("a", "aa", "aaa", "b", "bbb", "cccc")
                .sorted(Comparator.comparing(String::length).reversed()); // longest first...
        show("sortedStrings", sortedStrings);

        // 3. peek (useful for debug)
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();
        System.out.println(Arrays.toString(powers));
    }
}
