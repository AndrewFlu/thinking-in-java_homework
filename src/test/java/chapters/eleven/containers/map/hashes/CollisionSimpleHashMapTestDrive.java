package chapters.eleven.containers.map.hashes;

import chapters.containers.countries.Countries;

import java.util.Map;

public class CollisionSimpleHashMapTestDrive {
    public static void main(String[] args) {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        Map<String, String> countries = Countries.countries(5);
        Map<String, String> dupleCountries = Countries.countries(5);
        map.putAll(countries);
        map.putAll(dupleCountries);
        System.out.println(map);
    }
}
