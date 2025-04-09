package chapters.nineteen.enums.finite_state;

import java.util.Random;

public enum Input {
    NICKEL(5), // монета в 5 центов
    DIME(10), // монета в 10 центов
    QUARTER(25), // монета в 25 центов
    DOLLAR(100),  // монета в 100 центов

    TOOTHPASTE(200),
    CHIPS(75),
    SODA(100),
    SOAP(50),

    ABORT_TRANSACTION{
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP{
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    }
    ;

    private int value; // в центах

    Input(int value) {
        this.value = value;
    }

    Input() {}

    public int amount() {
        return value;
    }

    static Random rand = new Random(47);
    public static Input randomSelection() {
        // Не включая STOP
        return values()[rand.nextInt(values().length - 1)];
    }
}
