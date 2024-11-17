package chapters.fifteen.generics.contrcovariants.homework;

import chapters.forteen.typeinfo.pets.Cat;
import chapters.forteen.typeinfo.pets.Hamster;
import chapters.forteen.typeinfo.pets.Pet;

public class GenericsTestDrive {

    static <T> void printItemData(Generic1<? super T> generic1, T item) {
        generic1.printInfo(item);
    }

    static <T> T produceMethod(Generic2<? extends T> generic2) {
        return generic2.getItem();
    }

    public static void main(String[] args) {
        Cat sansa = new Cat("Санса");
        Cat dzem = new Cat("Джем");
        Hamster hamster = new Hamster("Телег");

        Generic1<Pet> genericPet = new Generic1<>();
        Generic1<Cat> genericCat = new Generic1<>();

        printItemData(genericPet, sansa);
        printItemData(genericPet, dzem);
        printItemData(genericPet, hamster);

        printItemData(genericCat, sansa);
        // Ошибка: обобщенный класс ограничен по суперклассу (Cat)
//        printItemData(genericCat, hamster);


        Generic2<Cat> generic2Cat = new Generic2<>();
        Generic2<Pet> generic2Pet = new Generic2<>();

        Cat cat = produceMethod(generic2Cat);
        Pet pet = produceMethod(generic2Pet);
        System.out.println(cat);
    }
}
