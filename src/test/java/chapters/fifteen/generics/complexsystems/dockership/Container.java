package chapters.fifteen.generics.complexsystems.dockership;

import chapters.fifteen.generics.generators.Generators;

import java.util.ArrayList;

public class Container extends ArrayList<Cargo> {
    private static long counter = 1;
    private final long id = counter++;

    public Container(int cargoCount) {
        Generators.fill(this, Cargo.generator, cargoCount);
    }

    @Override
    public String toString() {
        return "Контейнер id: " + id;
    }
}
