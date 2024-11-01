package chapters.fifteen.generics.complexsystems.store;

import java.util.ArrayList;

public class Aisle extends ArrayList<Shelf> {
    public Aisle(int shelfCount, int productCount) {
        for (int i = 0; i < shelfCount; i++) {
            add(new Shelf(productCount));
        }
    }
}
