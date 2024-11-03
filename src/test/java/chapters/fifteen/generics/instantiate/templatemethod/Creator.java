package chapters.fifteen.generics.instantiate.templatemethod;

public class Creator extends GenericWithCreate<X>{

    @Override
    X create() {
        return new X();
    }

    void function() {
        System.out.println(element.getClass().getSimpleName());
    }
}
