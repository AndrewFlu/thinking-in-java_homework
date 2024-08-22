package chapters.eleven.containers.list.iterator.rodent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RodentTestDrive {
    public static void main(String[] args) {
        List<Rodent> rodents = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rodents.add(RodentGenerator.next());
        }
        System.out.println(rodents);

        for (Rodent rodent : rodents) {
            System.out.println(rodent.getName());
            rodent.run();
        }
    }
}
