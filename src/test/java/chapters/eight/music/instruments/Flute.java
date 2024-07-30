package chapters.eight.music.instruments;

import chapters.eight.music.Note;

public class Flute extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("Flute.play() " + n);
    }
}
