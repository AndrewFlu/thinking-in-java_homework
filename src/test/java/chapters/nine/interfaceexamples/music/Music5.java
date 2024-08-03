package chapters.nine.interfaceexamples.music;

import chapters.eight.music.Note;

public class Music5 {
    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Brass(),
                new Percussion(),
                new Stringed(),
                new Wind(),
                new WoodWind(),
        };

        tuneAll(orchestra);
    }

    private static void tuneAll(Instrument[] instruments) {
        for (Instrument i : instruments) {
            tune(i);
        }
    }

    private static void tune(Instrument instrument) {
        instrument.play(Note.C_SHARP);
    }
}
