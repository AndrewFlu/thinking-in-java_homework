package chapters.fifteen.generics.constraints.epicbattle;

public class DogBoy extends CanineHero<SuperHearSmell> {
    DogBoy() {
        super(new SuperHearSmell());
    }
}
