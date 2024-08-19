package chapters.eleven.containers.list;

import java.util.Comparator;

public class Pet implements Comparator {
    private static int counter = 0;
    private final int id = counter++;

    public int id() {
        return id;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (((Pet) o1).id() > ((Pet) o2).id()) {
            return +1;
        } else if (((Pet) o1).id() == ((Pet) o2).id()) {
            return 0;
        } else return -1;
    }
}
