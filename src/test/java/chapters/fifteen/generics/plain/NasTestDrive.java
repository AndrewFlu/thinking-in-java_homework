package chapters.fifteen.generics.plain;

public class NasTestDrive {
    public static void main(String[] args) {
        NasHolder.Disc samsung1000 = new NasHolder.Disc(1000, "Samsung");
        NasHolder.Disc toshiba500 = new NasHolder.Disc(500, "Toshiba");
        NasHolder.Disc wd2024 = new NasHolder.Disc(2024, "WD");

        NasHolder<NasHolder.Disc> nas = new NasHolder<>(samsung1000, toshiba500, wd2024);
        System.out.println(nas.getOne());
        System.out.println(nas.getTwo());
        System.out.println(nas.getThree());
    }
}
