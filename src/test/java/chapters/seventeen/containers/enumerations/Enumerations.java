package chapters.seventeen.containers.enumerations;

import chapters.containers.countries.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Enumerations {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Countries.countryNames(10));
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements())
            System.out.print(enumeration.nextElement() + ", ");
        // Получение Enumeration для Collection
        Enumeration<String> enumeration1 = Collections.enumeration(new ArrayList<>());

    }
}
