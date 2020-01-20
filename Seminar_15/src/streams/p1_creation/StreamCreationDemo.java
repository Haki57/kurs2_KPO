package streams.p1_creation;

//This class is to demonstrate streams creation variants.

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreationDemo {
    private static final int SIZE = 100;

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        Integer[] array = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++){
            collection.add(i);
            array[i] = i;
        }

        // 1. Stream from collection:
        Stream<Integer> stream1 = collection.stream();
        show("stream1", stream1);

        // 2. Stream from array:
        Stream<Integer> stream2 = Stream.of(array);
        show("stream2", stream2);

        // 3. Stream from elements:
        Stream<String> stream3 = Stream.of("a", "aa", "aaa", "b", "bbb", "cccc");
        show("stream3", stream3);

        // 4. Stream from diapason in of an array:
        Stream<Integer> stream4 = Arrays.stream(array, 10, 15);
        show("stream4", stream4);

        // 5. Empty stream:
        Stream<String> emptyStream = Stream.empty();
        show("emptyStream", emptyStream);

        // 6. Generated [infinite] stream:
        Stream<Double> generatedStream1 = Stream.generate(Math::random);
        show("generatedStream1", generatedStream1);

        // 7.
        Stream<BigInteger> generatedStream2 = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("generatedStream2", generatedStream2);

        // 8. Stream by regular expression:
        String contents = "a\r\nb\r\nc\r\nd\r\nogogo\r\nhow\r\nnice\r\nto\r\nhave\r\ngood\r\nfriends";
        Stream<String> words = Pattern.compile("\\PL+").splitAsStream(contents);
        show("words", words);

        // 9. Stream from a text file (this source file):
        Path path = new File(".\\Seminar_15\\src\\streams\\p1_creation\\StreamCreationDemo.java").toPath();
        try {
            Stream<String> lines = Files.lines(path);
            show("lines of this source file", lines);

        } catch (IOException ex){
            System.out.println("got exception: " + ex);
        }

    }

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.size(); i++){
            if (i > 0)
                System.out.print(", ");
            if (i < SIZE)
                System.out.print(firstElements.get(i));
            else
                System.out.print("...");
        }
        System.out.println();
    }
}
