package chapters.fifteen.generics.constraints.epicbattle;

public class SuperHero <TPower extends SuperPower> {
    TPower power;

    SuperHero(TPower power) {
        this.power = power;
    }

    TPower getPower() {
        return power;
    }
}
