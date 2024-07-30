package chapters.eight.music;

public class WoodWind extends Wind {
    @Override
    void play(Note n) {
        System.out.println("WoodWind.play() " + n);
    }
}
