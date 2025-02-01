package chapters.fifteen.generics.innerclasses;

import net.mindview.utils.Generator;

public class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }

    @Override
    public String toString() {
        return "Customer with id = " + id;
    }
}
