package chapters.eight.starship;

public class RedStatus extends AlertStatus {
    @Override
    public void signal() {
        System.out.println("Горит красный сигнал");
    }
}