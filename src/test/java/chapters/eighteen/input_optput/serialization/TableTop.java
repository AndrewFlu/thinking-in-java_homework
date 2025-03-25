package chapters.eighteen.input_optput.serialization;

import java.io.Serializable;

public class TableTop implements Serializable {
    private String material;

    public TableTop(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Столешница: " + material;
    }
}
