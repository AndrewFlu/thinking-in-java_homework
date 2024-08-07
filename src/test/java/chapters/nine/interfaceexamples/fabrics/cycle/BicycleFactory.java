package chapters.nine.interfaceexamples.fabrics.cycle;

public class BicycleFactory implements ICycleFactory {
    @Override
    public ICycle getCycle() {
        return new Bicycle();
    }
}
