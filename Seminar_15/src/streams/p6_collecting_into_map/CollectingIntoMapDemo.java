package streams.p6_collecting_into_map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMapDemo {

    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name){
            this.id = id;
            this.name = name;
        }
        public int getId(){return id;}
        public String getName(){return name;}
        public String toString(){return getClass().getSimpleName() + "[id = " + id + "; name = " + name + "]";}
    }

    public static void main(String[] args) {
        CollectingIntoMapDemo instance = new CollectingIntoMapDemo();
        instance.personsDemo();
        instance.localeDemo();
        instance.groupingDemo();
    }

    private static Stream<Person> people() {
        return Stream.of(
                new Person(1001, "Ivanov"),
                new Person(1002, "Petrov"),
                new Person(1003, "Sidorov")
        );
    }

    private void personsDemo(){
System.out.println("-------------------------- personsDemo-------------------------------------");
        Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);

        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);
//        System.out.println("idToPerson: " + idToPerson);

        idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity(),
                (existingValue, newValue) -> {throw new IllegalStateException();},
                TreeMap::new));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);
    }

    private void localeDemo(){
System.out.println("-------------------------- localeDemo--------------------------------------");
//        Locale[] localesArray = Locale.getAvailableLocales();
//        System.out.println("localesArray["+localesArray.length+"] = " + Arrays.toString(localesArray));

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
            Collectors.toMap(
                Locale::getDisplayLanguage,
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue
            )
        );
        System.out.println("languageNames: " + languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect
            (Collectors.toMap(
                Locale::getDisplayCountry,
                l -> Collections.singleton(l.getDisplayLanguage()),
                (a, b) -> { // union of a and b
                    Set<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                }
            )
        );
        System.out.println("countryLanguageSets: " + countryLanguageSets);
    }

    private void groupingDemo(){
System.out.println("--------------------------groupingDemo-------------------------------------");
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        //1. groupingBy
        Map<String, List<Locale>> countryToLocales = locales.collect(
            Collectors.groupingBy(Locale::getCountry)
        );
        System.out.println("countryToLocales = " + countryToLocales);
        List<Locale> swissLocales = countryToLocales.get("CH");
        System.out.println("swissLocales = " + swissLocales);

        //2. partitioningBy
        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
            Collectors.partitioningBy(l -> l.getLanguage().equals("en"))
        );
        System.out.println("emglishAndOtheLocales = " + englishAndOtherLocales);
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        System.out.println("englishLocales = " + englishLocales);

    }
}
