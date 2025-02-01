package chapters.fifteen.generics.complexsystems.store;

import net.mindview.utils.Generator;

import java.util.Random;

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int idNumber, String desc, double price) {
        id = idNumber;
        description = desc;
        this.price = price;
//        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        @Override
        public Product next() {
            Random rand = new Random();
            return new Product(rand.nextInt(1000), "Random product", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}
