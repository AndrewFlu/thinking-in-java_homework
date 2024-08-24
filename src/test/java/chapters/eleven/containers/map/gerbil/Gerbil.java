package chapters.eleven.containers.map.gerbil;

public class Gerbil {
    private final int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public void hop() {
        System.out.println("Gerbil number is " + gerbilNumber);
    }
}
