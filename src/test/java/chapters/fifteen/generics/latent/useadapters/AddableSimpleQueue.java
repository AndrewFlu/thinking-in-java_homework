package chapters.fifteen.generics.latent.useadapters;

import chapters.fifteen.generics.latent.applymethod.SimpleQueue;

// Для адаптации конкретнрого типа можно применить наследование.
// Вклбчение Addable в SimpleQueue посредством наследования
public class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T element) {
        super.add(element);
    }
}
