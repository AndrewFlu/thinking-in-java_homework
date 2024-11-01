package chapters.fifteen.generics.complexsystems.dockership;

import java.util.ArrayList;

public class Ship extends ArrayList<Container> {
    public Ship(int containerCount, int cargoCount) {
        for (int i = 0; i < containerCount; i++) {
            add(new Container(cargoCount));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Container container : this) {
            sb.append(container);
            sb.append("\n");
            for (Cargo cargo : container) {
                sb.append("\t");
                sb.append(cargo);
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Ship ship = new Ship(2, 10);
        System.out.println(ship);
    }
}
