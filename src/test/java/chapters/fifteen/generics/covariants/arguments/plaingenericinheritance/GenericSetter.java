package chapters.fifteen.generics.covariants.arguments.plaingenericinheritance;

public class GenericSetter<T> { // без самоограничения
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}
