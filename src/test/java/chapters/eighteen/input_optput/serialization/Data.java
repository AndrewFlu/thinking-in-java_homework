package chapters.eighteen.input_optput.serialization;

import java.io.Serializable;

public class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }
    public String toString() {
        return Integer.toString(n);
    }
}
