package chapters.eight.starship;

public class StarShip {
    private AlertStatus alertStatus = new RedStatus();

    public void steady() {
        alertStatus = new YellowStatus();
    }

    public void go() {
        alertStatus = new GreenStatus();
    }

    public void fly() {
        alertStatus.signal();
    }
}