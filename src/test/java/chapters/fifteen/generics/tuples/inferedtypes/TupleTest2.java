package chapters.fifteen.generics.tuples.inferedtypes;

import chapters.fifteen.generics.tuples.FiveTuple;
import chapters.fifteen.generics.tuples.FourTuple;
import chapters.fifteen.generics.tuples.ThreeTuple;
import chapters.fifteen.generics.tuples.TwoTuple;
import chapters.fifteen.generics.tuples.test.Amphibian;
import chapters.fifteen.generics.tuples.test.Vehicle;

import static chapters.fifteen.generics.tuples.inferedtypes.Tuple.tuple;

public class TupleTest2 {
    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = func();
        System.out.println(ttsi);

        TwoTuple<String, Integer> ttsi2 = func2();
        System.out.println(ttsi2);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }

    private static FiveTuple k() {
        return tuple(15.5, "MacBook", "Pro", 1, true);
    }

    private static FourTuple h() {
        return tuple(new Vehicle(), new Amphibian(), "Hi", 15);
    }

    private static ThreeTuple g() {
        return tuple(new Amphibian(), "Yo", 5);
    }

    private static TwoTuple func2() {
        return tuple("Hi!", 101);
    }

    private static TwoTuple<String, Integer> func() {
        return new TwoTuple<>("Yo", 51);
    }
}
