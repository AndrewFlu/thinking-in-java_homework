package chapters.fifteen.generics.instantiate.withconstraint;

public class Widget {
    private String label;

    public Widget(String label) {
        this.label = label;
    }

    public static class Factory implements IFactory<Widget> {

        @Override
        public Widget create(String label) {
            return new Widget(label);
        }
    }

    @Override
    public String toString() {
        return "Widget{" +
                "label='" + label + '\'' +
                '}';
    }
}
