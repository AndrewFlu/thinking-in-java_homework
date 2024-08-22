package chapters.eleven.containers.list.iterator.customcollections;

import chapters.eleven.containers.list.iterator.customcollections.cars.Car;

import java.util.Collection;
import java.util.Iterator;

public class IteratorUtils {

    public static void printValues(Collection<? extends Car> collection) {
        Iterator<? extends Car> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String elementValue = iterator.next().toString();
            System.out.println(elementValue);
        }
        System.out.println();
    }
}
