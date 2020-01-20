package streams.p7_downstream_collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class DownstreamCollectorsDemo {
    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }
        public String getName(){return name;}
        public String getState(){return state;}
        public int getPopulation(){return population;}
    }

//    public static Stream<City> readCities(String filename) throws IOException {
//        return Files.lines(Paths.get(filename)).map(l -> l.split(", "))
//                .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
//    }

    //TODO: use this replacement instead of above - we had not discussed I/O yet...
    private static Stream<City> readCities() {
        return Stream.of(
            new City("New York", "NY", 8336697),
            new City("Los Angeles", "CA", 2714856),
            new City("Houston", "TX", 2160821),
            new City("Philadelphia", "PA", 1547607),
            new City("Phoenix", "AZ", 1488750),
            new City("San Antonio", "TX", 1382951),
            new City("San Diego", "CA", 1338348)
        );
    }

    public static void main(String[] args) throws IOException {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(
            Locale::getCountry, toSet()));
        System.out.println("countryToLocaleSet: " + countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(groupingBy(
            Locale::getCountry, counting()));
        System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

//        Stream<City> cities = readCities("cities.txt");
        Stream<City> cities = readCities();
        Map<String, Integer> stateToCityPopulation = cities.collect(groupingBy(
            City::getState, summingInt(City::getPopulation)));
        System.out.println("stateToCityPopulation: " + stateToCityPopulation);

//        cities = readCities("cities.txt");
        cities = readCities();
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(
            groupingBy(City::getState, mapping(City::getName, maxBy(Comparator.comparing(
                        String::length)
                    )
                )
            )
        );
        System.out.println("stateToLongestCityName: " + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(
            groupingBy(Locale::getDisplayCountry, mapping(Locale::getDisplayLanguage, toSet()))
        );
        System.out.println("countryToLanguages: " + countryToLanguages);

//        cities = readCities("cities.txt");
        cities = readCities();
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(
                groupingBy(City::getState, summarizingInt(City::getPopulation)));
        System.out.println(stateToCityPopulationSummary.get("NY"));

//        cities = readCities("cities.txt");
        cities = readCities();
        Map<String, String> stateToCityNames = cities.collect(
            groupingBy(City::getState, reducing(
                "",
                City::getName,
                (s, t) -> s.length() == 0 ? t : s + ", " + t)
            )
        );
        System.out.println("stateToCityNames: " + stateToCityNames);

//        cities = readCities("cities.txt");
        cities = readCities();
        stateToCityNames = cities.collect(
            groupingBy(City::getState, mapping(City::getName, joining(", ")))
        );
        System.out.println("stateToCityNames: " + stateToCityNames);
    }
}
