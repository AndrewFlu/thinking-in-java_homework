package chapters.fifteen.generics.innerclasses;

import utils.Generator;

public class BigFish {
    public static Generator<BigFish> generator = new Generator<BigFish>() {
        @Override
        public BigFish next() {
            return new BigFish();
        }
    };
    private static long counter = 1;
    private final long id = counter++;

    // closed constructor
    private BigFish() {
    }

    @Override
    public String toString() {
        return "BigFish with id " + id;
    }
}
