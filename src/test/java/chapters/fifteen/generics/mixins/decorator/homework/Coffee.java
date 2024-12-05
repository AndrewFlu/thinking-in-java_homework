package chapters.fifteen.generics.mixins.decorator.homework;

public abstract class Coffee {
    private String type;

    public Coffee() {
    }

    public Coffee(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Кофе: " + type;
    }
}
