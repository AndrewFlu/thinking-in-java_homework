package chapters.eight.music;

public class Instrument {

    void play(Note n) {
        System.out.println("Instrument.play() " + n);
    }

    final String what() {
        return toString();
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}
