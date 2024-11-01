package chapters.fifteen.generics.complexsystems.store;

import chapters.fifteen.generics.generators.Generators;

import java.util.ArrayList;

public class Shelf extends ArrayList<Product> {
    public Shelf(int productCapacity) {
        Generators.fill(this, Product.generator, productCapacity);
    }
}
