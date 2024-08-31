package chapters.eleven.containers.iterators.noncollection;

import chapters.eleven.containers.collectionanditerator.pets.Pet;

import java.util.Iterator;

public class NonCollectionSequenceTestDrive {
    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        printQ(nc.iterator());
    }

    private static void printQ(Iterator<Pet> iterator) {
        while (iterator.hasNext()) {
            Pet pet = iterator.next();
            System.out.println(pet.getType() + " " + pet.getName());
        }
        System.out.println();
    }
}
