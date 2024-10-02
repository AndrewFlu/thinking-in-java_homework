package chapters.forteen.typeinfo.factory.examples.cofee;

import utils.TypeCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CofeeGenerator {
    private static List<IFactory<? extends Cofee>> cofeesFactories = Arrays.asList(
            new Americano.Factory(),
            new Breve.Factory(),
            new Cappuccino.Factory(),
            new Latte.Factory(),
            new Mocha.Factory()
    );
    private static Random rand = new Random(47);

    public static List<Cofee> generateCofee(int size) {
        List<Cofee> cofeeList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cofeeList.add(getRandom());
        }

        return cofeeList;
    }

    public static Cofee getRandom() {
        int n = rand.nextInt(cofeesFactories.size());
        return cofeesFactories.get(n).create();
    }


    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Cofee.class);
        for (Cofee cofee : generateCofee(15)) {
            System.out.println(cofee);
            counter.count(cofee);
        }
        System.out.println();
        System.out.println(counter);
    }
}
