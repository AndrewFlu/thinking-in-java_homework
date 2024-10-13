package chapters.fifteen.generics.plain;

import chapters.forteen.typeinfo.pets.Cat;
import chapters.forteen.typeinfo.pets.Dog;
import chapters.forteen.typeinfo.pets.Pet;

public class PetHolderTestDrive {
    public static void main(String[] args) {
        Holder3<Pet> petHolder1 = new Holder3<>(new Cat("Sansa"));
        Holder3<Pet> petHolder2 = new Holder3<>(new Dog("Tuzik"));

        System.out.println(petHolder1.getA());
        System.out.println(petHolder2.getA());
    }
}
