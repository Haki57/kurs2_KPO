package streams.p5_optional;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class OptionalDemo {

    private static OptionalDemo instance;

    private static OptionalDemo getInstance(){
        if (instance == null) {
            instance = new OptionalDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        getInstance().methodsDemo();
        getInstance().flatMapDemo();
    }

    private void methodsDemo(){
        String contents = "a\r\nb\r\nc\r\nd\r\nogogo\r\nhow\r\nnice\r\nto\r\nhave\r\ngood\r\nfriends";

        // 1. use Optional orElse():
        Stream<String> wordsStream1 = Pattern.compile("\\PL+").splitAsStream(contents);
        Optional<String> firstLongWord1 = wordsStream1.filter(w -> w.length() > 3).findFirst();
        System.out.println("result = " + firstLongWord1.orElse("NO SUCH WORD"));

        Stream<String> wordsStream2 = Pattern.compile("\\PL+").splitAsStream(contents);
        Optional<String> firstLongWord2 = wordsStream2.filter(w -> w.length() > 8).findFirst();
        System.out.println("result = " + firstLongWord2.orElse("NO SUCH WORD"));

        // 2. use Optional orElseGet():
        Stream<String> wordsStream3 = Pattern.compile("\\PL+").splitAsStream(contents);
        Optional<String> firstLongWord3 = wordsStream3.filter(w -> w.length() > 8).findFirst();
        System.out.println("result = " + firstLongWord3.orElseGet(OptionalDemo::makeResponse));

        // 3. use isPresent(): //todo: note, that it is not better than check for null value... (see warning...)
        Stream<String> wordsStream4 = Pattern.compile("\\PL+").splitAsStream(contents);
        Optional<String> firstLongWord4 = wordsStream4.filter(w -> w.length() > 3).findFirst();
        if (firstLongWord4.isPresent()) {
            System.out.println(firstLongWord4.get());
        }

        // 4. use ifPresent(): //todo: not, that it is better than isPresent() above...
        Stream<String> wordsStream5 = Pattern.compile("\\PL+").splitAsStream(contents);
        Optional<String> firstLongWord5 = wordsStream5.filter(w -> w.length() > 3).findFirst();
        firstLongWord5.ifPresent(System.out::println);
    }

    private static String makeResponse(){
        return "NOTHING";
    }

    private static Optional<Double> inverse(Double x) {
        return x == 0? Optional.empty() : Optional.of(1 / x);
    }

    private static Optional<Double> squareRoot (Double x) {
        return x < 0 ? Optional.empty() : Optional.of( Math.sqrt(x));
    }

    private void flatMapDemo(){
        //1.
        double x = 4.0;
        Optional<Double> result = inverse(x).flatMap(OptionalDemo::squareRoot);
        result.ifPresent(System.out::println);

        //2.
        x = -4.0;
        result = inverse(x).flatMap(OptionalDemo::squareRoot);
        result.ifPresent(System.out::println);
        if (!result.isPresent()) //todo: find better solution to print diagnostic message in functional style...
            System.out.println(makeResponse());
    }
}
