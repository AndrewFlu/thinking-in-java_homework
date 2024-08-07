package chapters.nine.interfaceexamples.fabrics.cycle;


public class TricycleFactory implements ICycleFactory {
    @Override
    public ICycle getCycle() {
        return new Tricycle();
    }
}
