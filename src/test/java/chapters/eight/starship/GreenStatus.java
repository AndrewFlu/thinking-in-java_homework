package chapters.eight.starship;

public class GreenStatus extends AlertStatus {
    @Override
    public void signal() {
        System.out.println("Горит зелёный сигнал");
    }
}