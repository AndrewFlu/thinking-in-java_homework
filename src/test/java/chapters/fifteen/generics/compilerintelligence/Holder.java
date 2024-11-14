package chapters.fifteen.generics.compilerintelligence;

import chapters.fifteen.generics.covariants.fruits.Apple;
import chapters.fifteen.generics.covariants.fruits.Fruit;
import chapters.fifteen.generics.covariants.fruits.Orange;

public class Holder <T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());

        Apple appleHolderValue = appleHolder.getValue();
        appleHolder.setValue(appleHolderValue);

//        не может выполнить восходящее преобразование
//        Holder<Fruit> fruitHolder = appleHolderValue;

        Holder<? extends Fruit> fruitHolder = new Holder<>(appleHolderValue);
        Fruit fruitHolderValue = fruitHolder.getValue();

        // Возвращает Object
        appleHolderValue = (Apple) fruitHolder.getValue();
        try {
            // без предупреждений
            Orange orange = (Orange) fruitHolder.getValue();
        } catch (Exception e) {
            System.err.println(e);
        }

        // вызов set() невозможен
//        fruitHolder.setValue(new Apple());
//        fruitHolder.setValue(new Orange());
//        fruitHolder.setValue(new Fruit());

        System.out.println(fruitHolder.equals(appleHolderValue));
    }
}
