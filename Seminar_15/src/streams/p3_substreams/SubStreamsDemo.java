package streams.p3_substreams;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static streams.p1_creation.StreamCreationDemo.show;
import static streams.p2_filter_map_flatMap.FilerMapFlatMapDemo.letters;

public class SubStreamsDemo {
    public static void main(String[] args) {
        // 1. limit:
        Stream<Double> randoms = Stream.generate(Math::random).limit(5); // Substream of 5 numbers
        show("limit", randoms);

        // 2. skip:
        String contents = "a\r\nb\r\nc\r\nd\r\nogogo\r\nhow\r\nnice\r\nto\r\nhave\r\ngood\r\nfriends";
        Stream<String> wordsStream = Pattern.compile("\\PL+").splitAsStream(contents).skip(1);
        show("words", wordsStream);

        // 3. concat:
        Stream<String> combined = Stream.concat(letters("Hello"), letters("World"));
        show("combined", combined);
    }
}
