package chapters.eleven.containers.iterators.noncollection;

import chapters.eleven.containers.collectionanditerator.pets.Pet;
import chapters.eleven.containers.collectionanditerator.pets.Pets;

import java.util.*;

public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {

    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            private int index = pets.length - 1;

            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    @Override
                    public boolean hasNext() {
                        return index > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[index--];
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {

            private final Random random = new Random();

            @Override
            public Iterator<Pet> iterator() {
                var arrayList = new ArrayList<>(Arrays.asList(pets));
                Collections.shuffle(arrayList, random);

                return arrayList.iterator();
            }
        };
    }
}

class PetSequence {
    protected Pet[] pets = Pets.createArray(7);
}
