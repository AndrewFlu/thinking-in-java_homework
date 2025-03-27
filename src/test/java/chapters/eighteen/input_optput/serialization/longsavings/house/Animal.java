package chapters.eighteen.input_optput.serialization.longsavings.house;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private House preferredHouse;

    public Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }

    public String toString() {
        return name + "[" + "Animal" + "@" + Integer.toHexString(hashCode()) + "], " + preferredHouse + "\n";
    }

}
