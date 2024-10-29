package chapters.fifteen.generics.innerclasses;

import chapters.fifteen.generics.generators.Generators;

import java.util.*;

public class BankTeller {
    public static void main(String[] args) {
        Random random = new Random();

        Queue<Customer> customerQueue = new LinkedList<Customer>();
        Generators.fill(customerQueue, Customer.generator(), 15);

        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers, Teller.generator, 4);

        for (Customer customer : customerQueue) {
            serve(tellers.get(random.nextInt(tellers.size())), customer);
        }
    }

    private static void serve(Teller teller, Customer customer) {
        System.out.printf("Кассир [%s] обслуживает клиента [%s]\n", teller, customer);
    }
}
