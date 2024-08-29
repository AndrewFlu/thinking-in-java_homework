package chapters.eleven.containers.collectionanditerator.pets;

public class Dog implements Pet{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Собака";
    }
}
