package chapters.fifteen.generics.captureconversion;

import chapters.fifteen.generics.compilerintelligence.Holder;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder){
        T holderValue = holder.getValue();
        System.out.println(holderValue.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder integerHolder = new Holder<Integer>(5);

        f1(integerHolder); // выдаёт предупреждения
        f2(integerHolder); // без предупреждений

        Holder basicHolder = new Holder();
        basicHolder.setValue(new Object()); // предупреждение
        f2(basicHolder);

        // Восходящее преобразование к Holder<?>
        // тип всё равно определяется правильно
        Holder<?> wildCarded  = new Holder<Double>(1.1);
        f2(wildCarded);

    }
}
