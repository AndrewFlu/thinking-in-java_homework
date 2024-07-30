package chapters.eight.music;

import chapters.eight.music.instruments.*;

import java.util.Random;

public class InstrumentGenerator {
    private static final Random random = new Random();

    public static Instrument next() {
        int bound = 6;
        return switch (random.nextInt(bound)) {
            default -> new Flute();
            case 1 -> new Wind();
            case 2 -> new WoodWind();
            case 3 -> new Brass();
            case 4 -> new Stringed();
            case 5 -> new Percussion();
        };
    }
}
