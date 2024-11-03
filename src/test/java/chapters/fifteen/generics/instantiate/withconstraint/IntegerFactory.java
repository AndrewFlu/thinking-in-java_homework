package chapters.fifteen.generics.instantiate.withconstraint;

public class IntegerFactory implements IFactory<Integer>{
    @Override
    public Integer create() {
        return 0;
    }
}
