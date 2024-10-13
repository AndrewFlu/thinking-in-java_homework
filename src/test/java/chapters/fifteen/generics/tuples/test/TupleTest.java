package chapters.fifteen.generics.tuples.test;

import chapters.fifteen.generics.tuples.FiveTuple;
import chapters.fifteen.generics.tuples.FourTuple;
import chapters.fifteen.generics.tuples.ThreeTuple;
import chapters.fifteen.generics.tuples.TwoTuple;

public class TupleTest {
    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
//        ttsi.first = "there"; // ошибка компляции
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }

    private static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("Hi", 47);
    }

    private static ThreeTuple<Amphibian, Integer, String>g() {
        return new ThreeTuple<>(new Amphibian(), 46, "Yo!");
    }

    private static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "Hi!", 47);
    }

    private static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.2);
    }
}
