package chapters.eight.music.instruments;

import chapters.eight.music.Note;

public class WoodWind extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("WoodWind.play() " + n);
    }
}
