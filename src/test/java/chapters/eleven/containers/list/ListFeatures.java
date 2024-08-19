package chapters.eleven.containers.list;

import java.util.*;

import static net.midview.Print.print;

public class ListFeatures {
    public static void main(String[] args) {
        Random random = new Random();
        List<Pet> pets = Pets.arrayList(7);
        print("1: " + pets);
        Hamster hamster = new Hamster();
        pets.add(hamster);
        print("2: " + pets);
        print("3: " + pets.contains(hamster));
        pets.remove(hamster);
        Pet pet = pets.get(2);
        print("4: " + pet + " " + pets.indexOf(pet));
        Pet cymric = new Cymric();
        print("5: " + pets.indexOf(cymric));
        print("6: " + pets.remove(cymric));
        print("7: " + pets.remove(pet));
        print("8: " + pets);
        pets.add(3, new Mouse());
        print("9: " + pets);
        List<Pet> subList = pets.subList(1, 4);
        print("частичный список: " + subList);
        print("10: " + pets.containsAll(subList));
        Collections.sort(subList, Comparator.comparingInt(Objects::hashCode));
        print("после сортировки, sub: " + subList);
        print("после сортировки, pets: " + pets);
        print("11: " + pets.containsAll(subList));
        Collections.shuffle(subList, random);
        print("после перемешивания, sublist: " + subList);
        print("после перемешивания, pets: " + pets);
        print("12: " + pets.containsAll(subList));
        ArrayList<Pet> copy = new ArrayList<>(pets);
        subList = Arrays.asList(pets.get(1), pets.get(4));
        print("subList" + subList);
        copy.retainAll(subList);
        print("13: " + copy);
        copy = new ArrayList<Pet>(pets);
        copy.remove(2);
        print("14: " + copy);
        copy.removeAll(subList);
        print("15: " + copy);
        copy.set(1, new Mouse());
        print("16: " + copy);
        copy.addAll(2, subList);
        print("17: " + copy);
        print("18: " + pets.isEmpty());
        pets.clear();
        print("19: " + pets);
        print("20: " + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        print("21: " + pets);
        Object[] objects = pets.toArray();
        print("22: " + objects[3]);
        Pet[] petArray = pets.toArray(new Pet[0]);
        print("23: " + petArray[3].id());
        print("24: " + Arrays.toString(petArray));
    }
}
