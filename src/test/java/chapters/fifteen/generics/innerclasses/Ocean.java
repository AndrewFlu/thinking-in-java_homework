package chapters.fifteen.generics.innerclasses;

import chapters.fifteen.generics.generators.Generators;

import java.util.*;

public class Ocean {

    public static void main(String[] args) {
        Queue<SmallFish> smallFishQueue = new LinkedList<>();
        Generators.fill(smallFishQueue, SmallFish.generator(), 10);

        List<BigFish> bigFishList = new ArrayList<>();
        Generators.fill(bigFishList, BigFish.generator, 5);

        Random random = new Random();
        for (SmallFish small : smallFishQueue) {
            eat(bigFishList.get(random.nextInt(bigFishList.size())), small);
        }
    }

    private static void eat(BigFish bigFish, SmallFish small) {
        System.out.printf("Big fish [%s] eats smaller [%s]\n", bigFish, small);
    }
}
