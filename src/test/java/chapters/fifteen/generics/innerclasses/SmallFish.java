package chapters.fifteen.generics.innerclasses;

import net.mindview.utils.Generator;

public class SmallFish {
    private static long counter = 1;
    private final long id = counter++;

    // closed constructor
    private SmallFish() {
    }

    public static Generator<SmallFish> generator() {
        return new Generator<SmallFish>() {
            @Override
            public SmallFish next() {
                return new SmallFish();
            }
        };
    }

    @Override
    public String toString() {
        return "SmallFish with id: " + id;
    }
}
