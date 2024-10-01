package chapters.fifteen.generics.cofee;

import utils.Generator;
import utils.TypeCounter;

import java.util.Iterator;
import java.util.Random;

public class CofeeGenerator implements Generator<Cofee>, Iterable<Cofee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static Random rand = new Random(47);

    public CofeeGenerator() {
    }

    // для перебора
    private int size;

    public CofeeGenerator(int sz) {
        size = sz;
    }

    public Cofee next() {
        try {
            return (Cofee) types[rand.nextInt(types.length)].newInstance();

            // Сообщить программисту об ошибках во время выполнения
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CofeeIterator implements Iterator<Cofee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Cofee next() {
            count--;
            return CofeeGenerator.this.next();
        }

        // Не реализован
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Cofee> iterator() {
        return new CofeeIterator();
    }

    public static void main(String[] args) {
//        CofeeGenerator generator = new CofeeGenerator();
//        for (int i = 0; i < 5; i++) {
//            System.out.println(generator.next());
//        }
//        for (Cofee c : new CofeeGenerator(5)) {
//            System.out.println(c);
//        }
        TypeCounter counter = new TypeCounter(Cofee.class);
        for (Cofee cofee : new CofeeGenerator(15)) {
            System.out.println(cofee);
            counter.count(cofee);
        }
        System.out.println();
        System.out.println(counter);
    }
}
