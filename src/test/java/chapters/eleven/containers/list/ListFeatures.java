package chapters.eleven.containers.list;

import java.util.*;

import static net.midview.Print.print;

public class ListFeatures {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> ints = Ints.arrayList(5);
        print("1: " + ints);
        Integer five = 5;
        ints.add(five);
        print("2: " + ints);
        print("3: " + ints.contains(five));
        ints.remove(five);
        Integer secondIndex = ints.get(2);
        print("4: " + secondIndex + " — " + ints.indexOf(secondIndex));
        Integer newInt = 3;
        print("5: " + ints.indexOf(newInt));
        print("6: " + ints.remove(newInt));
        print("7: " + ints.remove(secondIndex));
        print("8: " + ints);
        ints.add(3, 30);
        print("9: " + ints);
        List<Integer> subList = ints.subList(1, 4);
        print("частичный список: " + subList);
        print("10: " + ints.containsAll(subList));
        Collections.sort(subList, Comparator.comparingInt(Integer::intValue));
        print("после сортировки, sub: " + subList);
        print("после сортировки, pets: " + ints);
        print("11: " + ints.containsAll(subList));
        Collections.shuffle(subList, random);
        print("после перемешивания, sublist: " + subList);
        print("после перемешивания, pets: " + ints);
        print("12: " + ints.containsAll(subList));
        ArrayList<Integer> copy = new ArrayList<>(ints);
        subList = Arrays.asList(ints.get(1), ints.get(4));
        print("subList" + subList);
        copy.retainAll(subList);
        print("13: " + copy);
        copy = new ArrayList<Integer>(ints);
        copy.remove(2);
        print("14: " + copy);
        copy.removeAll(subList);
        print("15: " + copy);
        copy.set(1, 50);
        print("16: " + copy);
        copy.addAll(2, subList);
        print("17: " + copy);
        print("18: " + ints.isEmpty());
        ints.clear();
        print("19: " + ints);
        print("20: " + ints.isEmpty());
        ints.addAll(Ints.arrayList(4));
        print("21: " + ints);
        Object[] objects = ints.toArray();
        print("22: " + objects[3]);
        Integer[] intsArray = ints.toArray(new Integer[0]);
        print("23: " + intsArray[3]);
        print("24: " + Arrays.toString(intsArray));
    }
}
