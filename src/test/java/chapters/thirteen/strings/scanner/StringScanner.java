package chapters.thirteen.strings.scanner;

import java.util.Scanner;

public class StringScanner {
    private static final String input = "BMW 5-series\n 3,0 6,5 15000 km";

    private String carModel;
    private double engineVolume;
    private float consumption;
    private int mileage;

    public StringScanner(String input) {
        Scanner scanner = new Scanner(input);
        if (scanner.hasNextLine()) carModel = scanner.nextLine();
        if (scanner.hasNextDouble()) engineVolume = scanner.nextDouble();
        if (scanner.hasNextFloat()) consumption = scanner.nextFloat();
        if (scanner.hasNextInt()) mileage = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "StringScanner{" +
                "carModel='" + carModel + '\'' +
                ", engineVolume=" + engineVolume +
                ", consumption=" + consumption +
                ", mileage=" + mileage +
                '}';
    }

    public static void main(String[] args) {
        StringScanner car = new StringScanner(input);
        System.out.println(car);
    }
}
