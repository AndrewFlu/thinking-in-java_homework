package chapters.nine.interfaceexamples.music;

import chapters.eight.music.Note;

public interface Instrument {
    int VALUE = 5; // static final

    void play(Note n);

    void adjust();

}
