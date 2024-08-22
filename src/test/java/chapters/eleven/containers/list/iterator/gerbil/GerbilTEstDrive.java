package chapters.eleven.containers.list.iterator.gerbil;

import java.util.ArrayList;
import java.util.Iterator;

public class GerbilTEstDrive {
    public static void main(String[] args) {
        ArrayList gerbils = new ArrayList();

        for (int i = 0; i < 5; i++) {
            gerbils.add(new Gerbil(i));
        }
        Iterator iterator = gerbils.iterator();
        while (iterator.hasNext()) {
            Gerbil next = (Gerbil) iterator.next();
            next.hop();
        }
    }
}
