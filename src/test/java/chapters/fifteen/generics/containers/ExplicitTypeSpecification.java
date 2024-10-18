package chapters.fifteen.generics.containers;

import chapters.forteen.typeinfo.pets.Person;
import chapters.forteen.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
    static void func(Map<Person, List<Pet>> petPeople) {

    }

    public static void main(String[] args) {
        func(New.<Person, List<Pet>>map());
    }
}
