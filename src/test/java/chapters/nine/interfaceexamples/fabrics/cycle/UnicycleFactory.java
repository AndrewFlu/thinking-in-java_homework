package chapters.nine.interfaceexamples.fabrics.cycle;

public class UnicycleFactory implements ICycleFactory {
    @Override
    public ICycle getCycle() {
        return new Unicycle();
    }
}
