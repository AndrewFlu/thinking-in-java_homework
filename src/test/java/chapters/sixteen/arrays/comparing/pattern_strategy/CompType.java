package chapters.sixteen.arrays.comparing.pattern_strategy;

import chapters.sixteen.arrays.generators.Generated;
import net.mindview.utils.Generator;

import java.util.Arrays;
import java.util.Random;

import static net.midview.Print.print;

public class CompType implements Comparable<CompType> {
    private static int count = 1;
    private static Random random = new Random();
    int i;
    int j;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0) result += "\n";

        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(random.nextInt(100), random.nextInt(100));
            }
        };
    }

    // test-drive
    public static void main(String[] args) {
        CompType[] c = Generated.array(CompType.class, CompType.generator(), 10);
        print("before sorting:");
        print(Arrays.toString(c));
        print("");
        Arrays.sort(c);
        print("after sorting:");
        print(Arrays.toString(c));
    }
}
