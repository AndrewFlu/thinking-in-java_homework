package chapters.fifteen.generics.containers;

import chapters.forteen.typeinfo.pets.Cat;
import chapters.forteen.typeinfo.pets.Person;
import chapters.forteen.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
        for (Map.Entry<Person, List<? extends Pet>> entry : petPeople.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("\t" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPerson = New.map();
        petPerson.put(new Person("Yana"), List.of(new Cat("Sansa"), new Cat("Dzem")));
        petPerson.put(new Person("Yura"), List.of(new Cat("Melkaya"), new Cat("Mladshaya"), new Cat("Novaya")));
        f(petPerson);
    }
}
