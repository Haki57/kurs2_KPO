package lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class Sample1_SortingStrings {
    private static final String[] STRINGS = {"a", "b", "c", "a111", "b22", "c3"};

    private Sample1_SortingStrings(){}

    //TODO: note that old style of pre-JDK 5...
    @SuppressWarnings("unchecked")
    private void sortWithAnonymousClassOld(String[] strings){
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, new Comparator() {
            public int compare(Object o1, Object o2) {
                return Integer.compare(((String)o1).length(), ((String)o2).length());
            }
        });
        System.out.println(Arrays.toString(strings));
    }
    // TODO:  using generics with anonymous class...
    private void sortWithAnonymousClass(String[] strings){
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(Arrays.toString(strings));
    }

    // TODO: using lambda...
    private void sortWithLambda(String[] strings){
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(Arrays.toString(strings));
    }

    // TODO: using static method reference...
    private void sortWithLMethod(String[] strings){
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strings));
    }

    public static void main(String[] args) {
        new Sample1_SortingStrings().sortWithAnonymousClassOld(STRINGS.clone()); //TODO: note clone()-method usage...
        new Sample1_SortingStrings().sortWithAnonymousClass(STRINGS.clone());
        new Sample1_SortingStrings().sortWithLambda(STRINGS.clone());
        new Sample1_SortingStrings().sortWithLMethod(STRINGS.clone());
    }
}


