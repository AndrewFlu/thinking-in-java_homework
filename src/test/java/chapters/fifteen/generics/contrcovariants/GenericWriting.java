package chapters.fifteen.generics.contrcovariants;

import chapters.fifteen.generics.covariants.fruits.Apple;
import chapters.fifteen.generics.covariants.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    public static void main(String[] args) {
        f1();
        f2();
    }

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
    }

    static <T> void writeWithWildCard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildCard(apples, new Apple());
        writeWithWildCard(fruits, new Apple());
    }
}
