package chapters.seven.composition;

public class Engine {
    String model;

    @Override
    public String toString() {
        if (model == null) {
            model = "N47D20A";
        }

        return model;
    }
}
