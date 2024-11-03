package chapters.fifteen.generics.instantiate.templatemethod;

abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}
