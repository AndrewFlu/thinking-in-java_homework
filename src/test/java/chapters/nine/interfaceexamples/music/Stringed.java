package chapters.nine.interfaceexamples.music;

import chapters.eight.music.Note;

public class Stringed implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println(".adjust()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}
