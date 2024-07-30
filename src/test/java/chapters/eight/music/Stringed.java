package chapters.eight.music;

public class Stringed extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Stringer.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringer");
    }
}
