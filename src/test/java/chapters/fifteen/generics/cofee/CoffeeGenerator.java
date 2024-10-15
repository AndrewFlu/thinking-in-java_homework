package chapters.fifteen.generics.cofee;

import utils.Generator;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    // для перебора
    private int size;

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();

            // Сообщить программисту об ошибках во время выполнения
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CofeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        // Не реализован
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator() {
        return new CofeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
//        TypeCounter counter = new TypeCounter(Cofee.class);
//        for (Cofee cofee : new CofeeGenerator(15)) {
//            System.out.println(cofee);
//            counter.count(cofee);
//        }
//        System.out.println();
//        System.out.println(counter);
    }
}
