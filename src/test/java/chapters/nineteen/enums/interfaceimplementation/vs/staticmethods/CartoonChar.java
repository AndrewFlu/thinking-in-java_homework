package chapters.nineteen.enums.interfaceimplementation.vs.staticmethods;

import chapters.nineteen.enums.interfaceimplementation.CartoonCharacter;

import java.util.Random;

public enum CartoonChar {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private Random rand = new Random(47);

    CartoonChar next() {
        return values()[rand.nextInt(values().length)];
    }
}
