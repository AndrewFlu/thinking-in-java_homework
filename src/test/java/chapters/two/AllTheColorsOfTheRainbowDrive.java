package chapters.two;

public class AllTheColorsOfTheRainbowDrive {
    public static void main(String[] args) {
        AllTheColorsOfTheRainbow colors = new AllTheColorsOfTheRainbow();
        System.out.println("Текущий цвет радуги: " + colors.anIntegerRepresentingColors);
        colors.changeTheHueOfTheColor(5551);
        System.out.println("Новый цвет радуги: " + colors.anIntegerRepresentingColors);
    }
}
