package chapters.fifteen.generics.compilerintelligence;

import chapters.fifteen.generics.covariants.fruits.Apple;
import chapters.fifteen.generics.covariants.fruits.Fruit;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> fruitList = Arrays.asList(new Apple());

        // без предупреждений
        Fruit fruit = fruitList.get(0);

        // Аргумент Object
        fruitList.contains(new Apple());
        fruitList.indexOf(new Apple());
    }
}
