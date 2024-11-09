package chapters.fifteen.generics.constraints.epicbattle;

public class SuperSleuth<TPower extends XRayVision> extends SuperHero<TPower>{

    SuperSleuth(TPower power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}
