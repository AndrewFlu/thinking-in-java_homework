package chapters.fifteen.generics.innerclasses;

import net.mindview.utils.Generator;

public class Teller {
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    @Override
    public String toString() {
        return "Teller with id = " + id;
    }


}
