package chapters.eight.music.instruments;

import chapters.eight.music.Note;

public class Percussion extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}
