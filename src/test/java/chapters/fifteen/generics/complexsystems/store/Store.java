package chapters.fifteen.generics.complexsystems.store;

import java.util.ArrayList;

public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
    private Office office = new Office();

    public Store(int aisleCount, int shelfCount, int productCount) {
        for (int i = 0; i < aisleCount; i++) {
            add(new Aisle(shelfCount, productCount));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }

        return result.toString();
    }

    // test-drive
    public static void main(String[] args) {
        System.out.println(new Store(2, 3, 10));
    }
}
