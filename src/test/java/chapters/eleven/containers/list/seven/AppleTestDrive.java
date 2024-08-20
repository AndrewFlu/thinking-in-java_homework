package chapters.eleven.containers.list.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleTestDrive {
    public static void main(String[] args) {
        Apple[] appleArray = {
                new Apple("Grenny Smith"),
                new Apple("Red"),
                new Apple("Cibirian"),
                new Apple("Polska Green"),
                new Apple("Белый налив")
        };
        List<Apple> apples = Arrays.asList(appleArray);
        List<Apple> appleSublist = apples.subList(1, 4);
        ArrayList<Apple> copy = new ArrayList<>(apples);
        copy.removeAll(appleSublist);
//        apples.removeAll(appleSublist); // не сработает, т.к. List создан из массива (unmodifiable)
        System.out.println(copy);
    }
}
