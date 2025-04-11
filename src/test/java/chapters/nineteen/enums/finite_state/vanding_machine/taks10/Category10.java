package chapters.nineteen.enums.finite_state.vanding_machine.taks10;

import chapters.nineteen.enums.finite_state.Input;

import java.util.EnumMap;

public enum Category10 {
    MONEY(Input.NICKEL, Input.DIME, Input.QUARTER, Input.DOLLAR),
    ITEM_SELECTION(Input.SODA, Input.TOOTHPASTE, Input.SODA),
    QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
    SHUT_DOWN(Input.STOP),
    ;

    private Input[] values;

    Category10(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category10> categories = new EnumMap<>(Input.class);

    static {
        for (Category10 c10 : Category10.class.getEnumConstants())
            for (Input type : c10.values)
                categories.put(type, c10);
    }

    public static Category10 categorise (Input input) {
        return categories.get(input);
    }

}
