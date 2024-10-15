package chapters.fifteen.generics.randomlist;

import chapters.forteen.typeinfo.pets.Pet;
import chapters.forteen.typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private final ArrayList<T> storage = new ArrayList<T>();
    private final Random random = new Random();

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    // test-drive
    public static void main(String[] args) {
        // string
        RandomList<String> rls = new RandomList<>();
        for (String s : ("The quick brown fox jumped over the lazy brown dog".split("\\s"))) {
            rls.add(s);
        }

        for (int i = 0; i < 15; i++) {
            System.out.print(rls.select() + " ");
        }

        System.out.println();

        // integer
        RandomList<Integer> randomInts = new RandomList<Integer>();
        for (int i = 0; i < 50; i++) {
            randomInts.add(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(randomInts.select() + " ");
        }
        System.out.println();

        // pets
        RandomList<Pet> randomPets = new RandomList<Pet>();
        Pet[] array = Pets.createArray(10);
        for (Pet pet : array) {
            randomPets.add(pet);
        }

        for (int i = 0; i < 30; i++) {
            System.out.print(randomPets.select() + " ");
        }
    }
}
