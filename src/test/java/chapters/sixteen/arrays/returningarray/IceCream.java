package chapters.sixteen.arrays.returningarray;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random random = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raising",
            "Praline Cream", "Mud Pie"
    };

    public static String[] getFlavorSet(int size) {
        if (size > FLAVORS.length) throw new IllegalArgumentException("Desired Set to Big");
        String[] results = new String[size];

        boolean[] picked  = new boolean[FLAVORS.length];
        for (int i = 0; i < size; i++) {
            int a;
            do {
                a = random.nextInt(FLAVORS.length);
            } while (picked[a]);
            results[i] = FLAVORS[a];
            picked[a] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(getFlavorSet(3)));
        }
    }
}
