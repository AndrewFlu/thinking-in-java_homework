package chapters.sixteen.arrays.generics;

import java.sql.Array;
import java.util.ArrayList;

public class PeelBanana {
    public static void main(String[] args) {
//        Peel<Banana>[] peels = new Peel<Banana>[10]; // Generic array creation not allowed
        ArrayList<Peel<Banana>[]> bananaPeels = new ArrayList<>(10);
        bananaPeels.add(new Peel[]{new Peel(), new Peel()});
        System.out.println(bananaPeels);
    }
}
