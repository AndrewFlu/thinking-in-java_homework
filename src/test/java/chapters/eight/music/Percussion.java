package chapters.eight.music;

public class Percussion extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}
