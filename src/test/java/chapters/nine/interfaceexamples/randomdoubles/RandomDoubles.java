package chapters.nine.interfaceexamples.randomdoubles;

import java.util.Random;

public class RandomDoubles {
    private static final Random rand = new Random();

    public static void main(String[] args) {

        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.println(rd.next() + "");
        }
    }

    protected double next() {
        return rand.nextDouble();
    }
}
