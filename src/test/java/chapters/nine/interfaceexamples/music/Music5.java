package chapters.nine.interfaceexamples.music;

import chapters.eight.music.Note;

public class Music5 {
    public static void main(String[] args) {
        Playable[] orchestra = {
                new Brass(),
                new Percussion(),
                new Stringed(),
                new Wind(),
                new WoodWind(),
        };

        tuneAll(orchestra);
    }

    private static void tuneAll(Playable[] instruments) {
        for (Playable i : instruments) {
            tune(i);
        }
    }

    private static void tune(Playable instrument) {
        instrument.play(Note.C_SHARP);
    }
}
