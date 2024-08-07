package chapters.nine.interfaceexamples.fabrics.cycle;

import static chapters.nine.interfaceexamples.fabrics.cycle.CycleFactories.cycleConsumer;

public class CycleFabricsTestDrive {
    public static void main(String[] args) {
        cycleConsumer(new BicycleFactory());
        cycleConsumer(new UnicycleFactory());
    }
}
