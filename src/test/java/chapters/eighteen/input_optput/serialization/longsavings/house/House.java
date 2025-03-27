package chapters.eighteen.input_optput.serialization.longsavings.house;

import java.io.Serializable;

public class House implements Serializable {
    public String toString() {
        return "House@" + Integer.toHexString(hashCode());
    }
}
