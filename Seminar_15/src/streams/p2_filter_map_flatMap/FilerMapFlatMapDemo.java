package streams.p2_filter_map_flatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static streams.p1_creation.StreamCreationDemo.show;

public class FilerMapFlatMapDemo {
    public static void main(String[] args) {

        //1. filter:
        String contents = "a\r\nb\r\nc\r\nd\r\nogogo\r\nhow\r\nnice\r\nto\r\nhave\r\ngood\r\nfriends";
        Stream<String> wordsStream = Pattern.compile("\\PL+").splitAsStream(contents);
        Stream<String> longWords = wordsStream.filter(w -> w.length() > 3);
        show("long words", longWords);

        //2. map:
        Stream<String> wordsStream1 = Pattern.compile("\\PL+").splitAsStream(contents);
        Stream<String> mapped1 = wordsStream1.map(String::toUpperCase);
        show("mapped1", mapped1);
        Stream<String> wordsStream2 = Pattern.compile("\\PL+").splitAsStream(contents);
        Stream<String> mapped2 = wordsStream2.map(w ->w.substring(0,1));
        show("mapped2", mapped2);

        //3. flatMap:
        String[] words = new String[]{"one", "two", "three", "four"};
        Stream<String> wStfream = Stream.of(words);
        Stream<String> flatResult = wStfream.flatMap(FilerMapFlatMapDemo::letters);
        show("flatMap", flatResult);
    }

    // the method to extract separate letters from a given string s
    public static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            result.add(s.substring(i, i + 1));
        return result.stream();
    }
}
