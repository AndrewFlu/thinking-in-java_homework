package chapters.fifteen.generics.latent.functional;

public class TankCombiner implements Combiner<Tank> {
    @Override
    public Tank combine(Tank x, Tank y) {
        return new Tank(x.getCapacity() + y.getCapacity());
    }
}
