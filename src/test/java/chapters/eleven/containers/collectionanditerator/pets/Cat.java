package chapters.eleven.containers.collectionanditerator.pets;

public class Cat implements Pet{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Кошка";
    }
}
