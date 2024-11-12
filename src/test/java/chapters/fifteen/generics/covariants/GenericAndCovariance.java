package chapters.fifteen.generics.covariants;

import chapters.fifteen.generics.covariants.fruits.Apple;
import chapters.fifteen.generics.covariants.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class GenericAndCovariance {
    public static void main(String[] args) {
        // Маски обеспечивают ковариантность
        List<? extends Fruit> fruitList = new ArrayList<Apple>();

        // Ошибка компиляции. Добавление элементов невозможно
//        fruitList.add(new Apple());
//        fruitList.add(new Orange());
//        fruitList.add(new Jonathan());

        // допустимо, но неинтересно
        fruitList.add(null);

        // Мы знаем, что возвращается как минимум Fruit
        Fruit fruit = fruitList.getFirst();

    }
}
