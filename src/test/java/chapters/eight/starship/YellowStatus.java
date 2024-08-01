package chapters.eight.starship;

public class YellowStatus extends AlertStatus {
    @Override
    public void signal() {
        System.out.println("Горит жёлтый сигнал");
    }
}
