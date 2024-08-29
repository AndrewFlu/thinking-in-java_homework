package chapters.eleven.containers.collectionanditerator;

import chapters.eleven.containers.collectionanditerator.pets.Pet;

import java.util.Collection;

public class PetCollectionTestDrive {
    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        printSequence(c);
    }

    private static void printSequence(Collection<Pet> pets) {
        for (Pet pet : pets) {
            System.out.println(pet.getType() + " " + pet.getName());
        }
    }
}
