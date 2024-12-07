package chapters.fifteen.generics.comparable;

public class Gecko extends ComparablePet {
    public int compareTo(ComparablePet arg) {
        return 0;
    }

    @Override
    public void speak() {
        System.out.println("...");
    }
}
