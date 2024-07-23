package chapters.five;

import static chapters.five.MoneyType.*;
import static net.midview.Print.print;

public class Money {
    private final MoneyType type;

    public Money(MoneyType type) {
        this.type = type;
    }

    public void describe() {
        switch (type) {
            case METAL -> print(type + " — Металлические монеты");
            case PAPER -> print(type + " — Бумажные купюры");
            case DIGIT -> print(type + " — Цифровые деньги");
            case CRYPTO -> print(type + " — Криптовалюта");
        }
    }
}

class MoneyTestDrive {
    public static void main(String[] args) {
        Money metalCoins = new Money(METAL),
                paper = new Money(PAPER),
                digit = new Money(DIGIT),
                crypto = new Money(CRYPTO);

        metalCoins.describe();
        paper.describe();
        digit.describe();
        crypto.describe();
    }
}
