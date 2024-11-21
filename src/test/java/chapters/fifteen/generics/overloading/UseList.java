package chapters.fifteen.generics.overloading;

import java.util.List;

public class UseList<W, T> {
    //    Не компилируется
    //    Перегрузка метода порождает идентичную сигнатуру из=за стирания
    //    void f(List<T> listT) {}
    void f(List<W> listW) {
    }
}
