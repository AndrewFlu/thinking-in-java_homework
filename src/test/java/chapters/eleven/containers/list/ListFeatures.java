package chapters.eleven.containers.list;

import java.util.*;

import static net.mindview.utils.Print.print;

public class ListFeatures {
    public static void main(String[] args) {
        Random random = new Random();
        List<String> strings = Strings.arrayList(5);
        print("1: " + strings);
        String addition = "addition";
        strings.add(addition);
        print("2: " + strings);
        print("3: " + strings.contains(addition));
        strings.remove(addition);
        String secondIndex = strings.get(2);
        print("4: " + secondIndex + " — " + strings.indexOf(secondIndex));
        String newString = "new string";
        print("5: " + strings.indexOf(newString));
        print("6: " + strings.remove(newString));
        print("7: " + strings.remove(secondIndex));
        print("8: " + strings);
        strings.add(3, "30");
        print("9: " + strings);
        List<String> subList = strings.subList(1, 4);
        print("частичный список: " + subList);
        print("10: " + strings.containsAll(subList));
        Collections.sort(subList, Comparator.comparingInt(String::length));
        print("после сортировки, sub: " + subList);
        print("после сортировки, pets: " + strings);
        print("11: " + strings.containsAll(subList));
        Collections.shuffle(subList, random);
        print("после перемешивания, sublist: " + subList);
        print("после перемешивания, pets: " + strings);
        print("12: " + strings.containsAll(subList));
        ArrayList<String> copy = new ArrayList<>(strings);
        subList = Arrays.asList(strings.get(1), strings.get(4));
        print("subList" + subList);
        copy.retainAll(subList);
        print("13: " + copy);
        copy = new ArrayList<>(strings);
        copy.remove(2);
        print("14: " + copy);
        copy.removeAll(subList);
        print("15: " + copy);
        copy.set(1, "50");
        print("16: " + copy);
        copy.addAll(2, subList);
        print("17: " + copy);
        print("18: " + strings.isEmpty());
        strings.clear();
        print("19: " + strings);
        print("20: " + strings.isEmpty());
        strings.addAll(Strings.arrayList(4));
        print("21: " + strings);
        Object[] objects = strings.toArray();
        print("22: " + objects[3]);
        String[] intsArray = strings.toArray(new String[0]);
        print("23: " + intsArray[3]);
        print("24: " + Arrays.toString(intsArray));
    }
}
