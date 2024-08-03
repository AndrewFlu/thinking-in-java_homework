package chapters.nine.abstractexamples.downcasting;

public class SoundChecker {
    public static void checkSound(Motorcycle bike) {
        String sound = bike.sound();
        System.out.println(sound);
    }
}
