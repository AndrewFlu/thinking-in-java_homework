package chapters.eleven.containers.gerbil;

import java.util.ArrayList;

public class GerbilTEstDrive {
    public static void main(String[] args) {
        ArrayList gerbils = new ArrayList();
        for (int i = 0; i < 5; i++) {
            gerbils.add(new Gerbil(i));
        }
        for (int i = 0; i < gerbils.size(); i++) {
            ((Gerbil)gerbils.get(i)).hop();
        }
    }
}
