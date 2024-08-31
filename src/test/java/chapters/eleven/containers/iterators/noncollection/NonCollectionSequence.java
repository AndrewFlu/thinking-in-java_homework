package chapters.eleven.containers.iterators.noncollection;

import chapters.eleven.containers.collectionanditerator.pets.Pet;
import chapters.eleven.containers.collectionanditerator.pets.Pets;

import java.util.Iterator;

public class NonCollectionSequence extends PetSequence {


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
}

class PetSequence {
    protected Pet[] pets = Pets.createArray(7);
}
