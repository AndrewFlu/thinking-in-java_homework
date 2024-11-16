package chapters.fifteen.generics.contrcovariants;

import chapters.fifteen.generics.covariants.fruits.Apple;
import chapters.fifteen.generics.covariants.fruits.Fruit;
import chapters.fifteen.generics.covariants.fruits.Jonathan;

import java.util.List;

public class SuperTypeWildCards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // ошибка
//        apples.add(new Fruit());
    }
}
