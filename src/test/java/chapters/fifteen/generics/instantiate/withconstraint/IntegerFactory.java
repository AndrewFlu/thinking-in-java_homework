package chapters.fifteen.generics.instantiate.withconstraint;

public class IntegerFactory implements IFactory<Integer>{

    @Override
    public Integer create(String label) {
        try {
            return Integer.parseInt(label);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
