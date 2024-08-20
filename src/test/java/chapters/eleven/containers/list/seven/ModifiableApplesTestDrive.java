package chapters.eleven.containers.list.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifiableApplesTestDrive {
    public static void main(String[] args) {
        List<Apple> unmodifiableApples = Arrays.asList(
                new Apple("1"),
                new Apple("2"),
                new Apple("3"),
                new Apple("4"),
                new Apple("5")
        );

        List<Apple> modifiableApples = new ArrayList<>(unmodifiableApples);

        List<Apple> subList = modifiableApples.subList(1, 4);
        modifiableApples.removeAll(subList);
        System.out.println(modifiableApples);
    }
}
