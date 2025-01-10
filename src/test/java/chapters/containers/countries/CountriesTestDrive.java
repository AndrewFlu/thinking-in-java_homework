package chapters.containers.countries;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static chapters.containers.countries.Countries.countries;

public class CountriesTestDrive {
    public static void main(String[] args) {
        Map<String, String> countryMap = countries();
        printCountryInfo(countryMap);
//
        // Задание 1
//        System.out.println();
//        System.out.println("ArrayList: ");
//        ArrayList<String> names = new ArrayList<>(Countries.countryNames());
//        System.out.println(names);
//        Collections.shuffle(names, new Random());
//        System.out.println("shuffled: " + names);
//
//        System.out.println();
//        System.out.println("LinkedList: ");
//        System.out.println(new LinkedList<>(names));
//        Collections.shuffle(names, new Random());
//        System.out.println("shuffled: " + names);
        // Задание 2
        Map<String, String> aCountries = countries().keySet().stream()
                .filter(c -> c.startsWith("A"))
                .collect(Collectors.toMap(Function.identity(), Function.identity()));
        System.out.println("All countries starts with 'A' (Map): ");
        printCountryInfo(aCountries);

        Set<String> countries = Countries.countries().keySet();
        System.out.println("All countries (Set): ");
        System.out.println(countries);
        System.out.println("A country starts with 'C': ");
        for (String str : countries) {
            if (str.startsWith("C")) {
                System.out.println(str);
            }
        }
    }

    public static void printCountryInfo(Map<String, String> countryMap) {
        for (String key : countryMap.keySet()) {
            System.out.printf("Country [%s] has a capital [%s]%n", key, countryMap.get(key));
        }
    }
}
