package chapters.two.statics;

import java.util.Arrays;

public class Apple {
    static int fruitId = 545;
    String color;
    int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public static Integer getAllFruitsWeight(Apple... apples){
        return Arrays.stream(apples).map(a -> a.weight).mapToInt(Integer::intValue).sum();
    }
}
