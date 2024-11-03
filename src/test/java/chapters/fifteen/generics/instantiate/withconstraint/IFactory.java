package chapters.fifteen.generics.instantiate.withconstraint;

public interface IFactory<T> {
    T create(String label);
}
