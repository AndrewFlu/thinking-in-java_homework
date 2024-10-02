package chapters.forteen.typeinfo.factory.examples.pets;

import chapters.forteen.typeinfo.pets.PetCount;

public class FactoryPetCreatorTestDrive {
    public static void main(String[] args) {
        PetCount.countPets(PetsPhasade.creator);
    }
}
