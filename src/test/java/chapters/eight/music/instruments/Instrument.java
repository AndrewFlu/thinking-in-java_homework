package chapters.eight.music.instruments;

import chapters.eight.music.Note;

public class Instrument {

    public void play(Note n) {
        System.out.println("Instrument.play() " + n);
    }

    public final String what() {
        return toString();
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}
