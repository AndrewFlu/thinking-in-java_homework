package chapters.eight.music;

public class Flute extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Flute.play() " + n);
    }
}
