package chapters.containers.countries;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static chapters.containers.countries.Countries.countries;

public class CountriesTestDrive {
    public static void main(String[] args) {
        Map<String, String> countryMap = countries();
        printCountryInfo(countryMap);

        System.out.println();
        System.out.println("ArrayList: ");
        ArrayList<String> names = new ArrayList<>(Countries.countryNames());
        System.out.println(names);
        Collections.shuffle(names, new Random());
        System.out.println("shuffled: " + names);

        System.out.println();
        System.out.println("LinkedList: ");
        System.out.println(new LinkedList<>(names));
        Collections.shuffle(names, new Random());
        System.out.println("shuffled: " + names);
    }

    public static void printCountryInfo(Map<String, String> countryMap) {
        for (String key : countryMap.keySet()) {
            System.out.printf("Country [%s] has a capital [%s]%n", key, countryMap.get(key));
        }
    }
}
