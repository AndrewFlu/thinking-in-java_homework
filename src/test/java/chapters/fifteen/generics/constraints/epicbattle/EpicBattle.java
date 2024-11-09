package chapters.fifteen.generics.constraints.epicbattle;

import java.util.List;

public class EpicBattle {
    // ограничения в обощённых методах
    static <TPower extends SuperHearing> void useSuperHearing(SuperHero<TPower> hero) {
        hero.getPower().hearSubtleNoises();
    }

    static <TPower extends SuperHearing & SuperSmell> void superFind(SuperHero<TPower> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);

        // так поступить можно
        List<? extends SuperHearing> audioBoys;
        // а так нельзя
//        List<? extends SuperHearing & SuperSmell> dogBoys;

    }
}
