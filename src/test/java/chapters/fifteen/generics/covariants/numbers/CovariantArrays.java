package chapters.fifteen.generics.covariants.numbers;

import java.util.ArrayList;
import java.util.List;

public class CovariantArrays {
    public static void main(String[] args) {
        List<? extends Number> numberList = new ArrayList<Integer>();
//        numberList.add(new Integer(1)); // ошибка компиляции, т.к.
//        incompatible types: java.lang.Integer cannot be converted to capture#1 of ? extends java.lang.Number

        Number number = numberList.getFirst();
        System.out.println(numberList);
    }
}
