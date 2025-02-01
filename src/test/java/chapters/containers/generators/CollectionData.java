package chapters.containers.generators;

import chapters.sixteen.arrays.generators.RandomGenerator;
import net.mindview.utils.Generator;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    // обобщённый метод
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }

    public static void main(String[] args) {
        CollectionData<Integer> intCollection = CollectionData.list(new RandomGenerator.Integer(), 5);
        System.out.println(intCollection);
    }
}
