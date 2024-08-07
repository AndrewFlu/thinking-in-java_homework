package chapters.nine.interfaceexamples.fabrics.cycle;

public class CycleFactories {
    public static void cycleConsumer(ICycleFactory cycleFactory) {
        ICycle cycle = cycleFactory.getCycle();
        cycle.drive();
        System.out.println(String.format("%s имеет %s колесо(-а)", cycle.getClass().getSimpleName(), cycle.getWheels()));
    }
}
