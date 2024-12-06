package chapters.fifteen.generics.latent.simple;

public class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.sit();
        performer.speak();
    }
}
