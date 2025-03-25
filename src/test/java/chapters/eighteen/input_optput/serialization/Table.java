package chapters.eighteen.input_optput.serialization;

import java.io.Serial;
import java.io.Serializable;

public class Table implements Serializable {
    private TableTop tableTop;

    public Table(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    @Override
    public String toString() {
        return "Стол со столешницей: " + tableTop;
    }
}
