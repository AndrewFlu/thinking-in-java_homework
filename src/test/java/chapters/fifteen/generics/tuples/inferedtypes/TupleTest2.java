package chapters.fifteen.generics.tuples.inferedtypes;

import chapters.eight.shapes.Shape;
import chapters.fifteen.generics.tuples.*;
import chapters.fifteen.generics.tuples.test.Amphibian;
import chapters.fifteen.generics.tuples.test.Vehicle;

import static chapters.fifteen.generics.tuples.inferedtypes.Tuple.tuple;

public class TupleTest2 {
    public static void main(String[] args) {
        TwoTuple<String, Integer> func = func();
        TwoTuple func2 = func2();
        System.out.println(func);
        System.out.println(func2);

        System.out.println();
        System.out.println("func() == func2() ? " + func.equals(func2));
        System.out.println();
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(sixFunc());
    }

    private static SixTuple sixFunc() {
        return tuple(1, 2.2, "Three", new Shape(4), 5.5f, true);
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
        return tuple("Yo", 51);
    }

    private static TwoTuple<String, Integer> func() {
        return new TwoTuple<>("Yo", 51);
    }
}
