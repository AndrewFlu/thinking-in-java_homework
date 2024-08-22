package chapters.eleven.containers.list.iterator.customcollections;

import chapters.eleven.containers.list.iterator.customcollections.cars.Audi;
import chapters.eleven.containers.list.iterator.customcollections.cars.Bmw;
import chapters.eleven.containers.list.iterator.customcollections.cars.Car;

import java.util.*;

public class IteratorUtilsTestDrive {
    public static void main(String[] args) {
        Car[] cars = {new Mersedes(), new Bmw(), new Audi(), new Bmw()};
        List<Car> carList = Arrays.asList(cars);
        Collection<Car> carsArrayList = new ArrayList<>(carList);
        Collection<Car> carsLinkedList = new LinkedList<>(carList);
        Collection<Car> carsHashSet = new HashSet<>(carList);
        Collection<Car> carsLinkedHashSet = new LinkedHashSet<>(carList);
        Collection<Car> carsTreeSet = new TreeSet<>(carList);

        IteratorUtils.printValues(carsArrayList);
        IteratorUtils.printValues(carsLinkedList);
        IteratorUtils.printValues(carsHashSet);
        IteratorUtils.printValues(carsLinkedHashSet);
        IteratorUtils.printValues(carsTreeSet);
    }
}
