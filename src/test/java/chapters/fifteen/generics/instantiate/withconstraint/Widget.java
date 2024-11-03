package chapters.fifteen.generics.instantiate.withconstraint;

public class Widget {
    public static class Factory implements IFactory<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
