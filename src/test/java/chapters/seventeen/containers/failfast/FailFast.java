package chapters.seventeen.containers.failfast;

import chapters.containers.countries.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class FailFast {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>(Countries.countryNames(7));
        Iterator<String> iterator = collection.iterator();
        collection.add("one");
        try {
            iterator.next();
        } catch (ConcurrentModificationException  ex) {
            System.out.println(ex);
        }
    }
}
