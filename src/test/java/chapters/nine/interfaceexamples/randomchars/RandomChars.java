package chapters.nine.interfaceexamples.randomchars;

import java.util.Random;

public class RandomChars {
    private static final Random rand = new Random();
    public static final int LOWER_ASCI_CODE = 97;
    public static final int UPPER_ASCI_CODE = 123;

    protected char getSingleRandomChar() {
        return (char) rand.nextInt(LOWER_ASCI_CODE, UPPER_ASCI_CODE);
    }
}
