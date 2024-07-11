package chapters.two.statics;

import java.util.ArrayList;

public class AppleTestDrive {
    public static void main(String[] args) {
        Apple redApple = new Apple("red", 150);
        Apple greenApple = new Apple("green", 100);
        System.out.println("Все яблоки имеют один идентификатор для своего класса фруктов");
        System.out.println("redApple.fruitId " + redApple.fruitId);
        System.out.println("green.fruitId " + greenApple.fruitId);

        System.out.println("Но каждое яблоко уникально");
        System.out.println("red apple имеет цвет " + redApple.color);
        System.out.println("red apple имеет вес " + redApple.weight);
        System.out.println("green apple имеет цвет " + greenApple.color);
        System.out.println("green apple имеет вес " + greenApple.weight);

        Apple[] apples = new Apple[]{
                redApple,
                greenApple
        };
        Integer allFruitsWeight = Apple.getAllFruitsWeight(apples);
        System.out.println("Общий вес всех яблок = " + allFruitsWeight);
    }
}
