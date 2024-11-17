package chapters.fifteen.generics.captureconversion.homework;

import chapters.fifteen.generics.compilerintelligence.Holder;

import java.util.Arrays;
import java.util.List;

public class ListCaptureConversion {
    static void testWildCardedType(Holder<List<?>> holder) {
        List<?> holdersValue = holder.getValue();
        for (Object obj : holdersValue) {
            System.out.println(obj);
        }
        Object object = holdersValue.getFirst();
//        holdersValue.set(0, Integer.parseInt("5")); // ошибка: ожидается тип "capture of ?"

        holder.setValue(Arrays.asList(5, 1));
    }

    static void testWildCardedHolder(List<Holder<?>> listOfHolder) {
        Holder<?> first = listOfHolder.getFirst();
//        listOfHolder.set(0, new Holder<Integer>(1)); // UnsupportedOperationException

        Object value = first.getValue();
//        first.setValue(1);  // ошибка: ожидается тип "capture of ?"

        for(Holder<?> holder : listOfHolder) {
            System.out.println(holder.getValue().getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Holder<List<?>> holders = new Holder<>(Arrays.asList(1,2,3,4,5));
        testWildCardedType(holders);

        testWildCardedHolder(List.of(
                new Holder<>("Hi!"),
                new Holder<>(1),
                new Holder<>(1.1)
        ));
    }
}
