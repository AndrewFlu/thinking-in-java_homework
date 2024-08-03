package chapters.nine.abstractexamples.downcasting;

public class MotorcycleSoundTestDrive {
    public static void main(String[] args) {
        Motorcycle bmwRNineT = new RnineT();
        Motorcycle hDSportster = new Sportster();

        SoundChecker.checkSound(bmwRNineT);
        SoundChecker.checkSound(hDSportster);
    }
}
