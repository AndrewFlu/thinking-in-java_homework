package chapters.fifteen.generics.constraints.epicbattle;

public class CanineHero <TPower extends SuperHearing & SuperSmell> extends SuperHero<TPower>{
    CanineHero(TPower power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}
