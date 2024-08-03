package chapters.nine.abstractexamples.rodent;

import java.util.Arrays;

public class RodentTestDrive {
    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[3];
        for (int i = 0; i < rodents.length; i++) {
            rodents[i] = RodentGenerator.next();
        }
        System.out.println(Arrays.toString(rodents));

        for (Rodent r : rodents) {
            System.out.println(r.getName());
            r.eat();
            r.run();
            System.out.println("");
        }
    }
}
