package chapters.eight.music.instruments;

import chapters.eight.music.Note;

public class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Stringer.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringer");
    }
}
