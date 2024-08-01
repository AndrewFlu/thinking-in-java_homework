package chapters.eight.starship;

public class StarShipTestDrive {
    public static void main(String[] args) {
        StarShip starShip = new StarShip();
        starShip.fly();
        starShip.steady();
        starShip.fly();
        starShip.go();
        starShip.fly();
    }
}