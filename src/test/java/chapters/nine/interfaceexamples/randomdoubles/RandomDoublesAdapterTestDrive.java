package chapters.nine.interfaceexamples.randomdoubles;

import java.util.Scanner;

public class RandomDoublesAdapterTestDrive {
    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNext()) {
            System.out.println(s.next() + " ");
        }
    }
}
