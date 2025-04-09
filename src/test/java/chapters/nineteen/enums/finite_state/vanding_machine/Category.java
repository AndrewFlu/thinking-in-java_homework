package chapters.nineteen.enums.finite_state.vanding_machine;

import chapters.nineteen.enums.finite_state.Input;

import java.util.EnumMap;

import static chapters.nineteen.enums.finite_state.Input.*;

public enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP),
    ;

    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants())
            for (Input type : c.values)
                categories.put(type, c);
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
