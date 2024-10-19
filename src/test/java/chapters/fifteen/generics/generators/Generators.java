package chapters.fifteen.generics.generators;

import chapters.fifteen.generics.cofee.Coffee;
import chapters.fifteen.generics.cofee.CoffeeGenerator;
import chapters.fifteen.generics.fibonacci.FibonacciGenerator;
import utils.Generator;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(gen.next());
        }

        return collection;
    }

    // test-drive
    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(
                new ArrayList<Coffee>(),
                new CoffeeGenerator(),
                5
        );

        for (Coffee c : coffees) {
            System.out.println(c);
        }

        Collection<Integer> fnumbers = fill(
                new ArrayList<>(),
                new FibonacciGenerator(),
                10
        );

        for (int i : fnumbers) {
            System.out.println(i);
        }
    }
}
