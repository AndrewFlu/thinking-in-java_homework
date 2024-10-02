package chapters.forteen.typeinfo.factory.examples.pets;

import chapters.forteen.typeinfo.pets.PetCreator;

public class PetsPhasade {
    public static final PetCreator creator = new FactoryPetCreator();

}
