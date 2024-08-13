package chapters.ten.locals.guitars;

public class GuitarTestDrive {
    public static void main(String[] args) {
        Guitar electroAcoustic = new Guitar(true);
        Guitar acoustic = new Guitar(false);

        electroAcoustic.prepareToPlay();
        acoustic.prepareToPlay();
    }
}
