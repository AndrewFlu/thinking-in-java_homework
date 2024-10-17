package chapters.fifteen.generics.strorycharacters.marvel.infinitywar;

public class Character {
    protected String name;

    @Override
    public String toString() {
        return "Character:" +
                " name = " + name +
                ", type = " + getClass().getSuperclass().getSimpleName();
    }
}
