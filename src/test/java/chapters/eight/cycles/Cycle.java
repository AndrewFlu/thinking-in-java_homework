package chapters.eight.cycles;

public class Cycle {
    private int wheels;

    public void ride() {
        System.out.println(String.format("У любого экземпляра класса %s количество колёс = %s", getClass().getSimpleName(), wheels()));
    }

    public int wheels() {
        return wheels;
    }
}
