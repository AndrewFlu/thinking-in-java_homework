package chapters.fifteen.generics.contrcovariants;

import chapters.fifteen.generics.covariants.fruits.Apple;
import chapters.fifteen.generics.covariants.fruits.Fruit;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    // Статический метод адаптируется к каждому вызову:
    static void f1() {
        Apple apple = readExact(apples);
        Fruit fruit = readExact(fruits);
        fruit = readExact(apples);
    }

    // Но если речь идёт о классе, тип устанавливается
    // при создании экземпляра класса
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit fruit = fruitReader.readExact(fruits);
        // fruitReader.readExact(apples); // ошибка. Присвоен тип Fruit при создании экземпляра Reader
    }

    static class CovariantReader<T> {
        T readcovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        fruitReader.readcovariant(fruits);
        fruitReader.readcovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
