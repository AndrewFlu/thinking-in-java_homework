package chapters.fifteen.generics.latent.useadapters;

import chapters.fifteen.generics.cofee.Americano;
import chapters.fifteen.generics.cofee.Coffee;
import chapters.fifteen.generics.cofee.Latte;
import chapters.forteen.typeinfo.interfaceviolation.A;
import chapters.forteen.typeinfo.pets.Cat;
import chapters.forteen.typeinfo.pets.Dog;
import chapters.forteen.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class Fill2TestDrive {
    public static void main(String[] args) {
        // Адаптиция Collection
        List<Pet> petsList = new ArrayList<>();


        Fill2.fill(new AddableCollectionAdapter<Pet>(petsList), Pet.class, 5);

        // Вспомогательный метод фиксирует тип
        Fill2.fill(Adapter.collectionAdapter(petsList), Pet.class, 4);

        for (Pet pet : petsList) {
            System.out.println(pet);
        }
        System.out.println("------------");

        // Использование адаптированного класса
        AddableSimpleQueue<Pet> petsQueue = new AddableSimpleQueue<>();
        Fill2.fill(petsQueue, Cat.class, 5);
        Fill2.fill(petsQueue, Dog.class, 2);
        for (Pet pet : petsQueue) {
            System.out.println(pet);
        }
    }
}
