package chapters.fifteen.generics.generators;

import chapters.fifteen.generics.cofee.Coffee;
import chapters.fifteen.generics.cofee.CoffeeGenerator;
import chapters.fifteen.generics.fibonacci.FibonacciGenerator;
import utils.Generator;

import java.util.*;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> gen, int n) {
        System.out.println("version for Collection");
        for (int i = 0; i < n; i++) {
            collection.add(gen.next());
        }
        return collection;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        System.out.println("version for List");
        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }
        return list;
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
        System.out.println("version for Set");
        for (int i = 0; i < n; i++) {
            set.add(gen.next());
        }
        return set;
    }

    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {
        System.out.println("version for Queue");
        for (int i = 0; i < n; i++) {
            queue.add(gen.next());
        }
        return queue;
    }

    // test-drive
    public static void main(String[] args) {
        // List
        Collection<Coffee> coffees = fill(
                new ArrayList<Coffee>(),
                new CoffeeGenerator(),
                5
        );

        for (Coffee c : coffees) {
            System.out.println(c);
        }

        // Set
        Generator<String> stringGenerator = new StringGenerator();
        Collection<String> stringSet = fill(new HashSet<>(), stringGenerator, 3);
        for (String s : stringSet) {
            System.out.println(s);
        }

        //Queue
        Collection<Integer> fibonacci = fill(new PriorityQueue<>(), new FibonacciGenerator(), 10);
        for (Integer f : fibonacci) {
            System.out.println(f);
        }
    }

    private static class StringGenerator implements Generator<String> {
        private Random random = new Random();

        @Override
        public String next() {
            char[] chars = {'a', 'b', 'c'};
            return String.valueOf(chars[random.nextInt(chars.length)]);
        }
    }
}
