package chapters.three;

public class SpeedController {
    public static double getSpeedInfo(double distanceInMeters, double timeInMinutes) {
        double speed = (distanceInMeters / 1000) / (timeInMinutes / 60);
        System.out.printf("Пройдено %s метров за %s минут. ", distanceInMeters, timeInMinutes);
        System.out.printf("Скорость = %s км./ч.%n", speed);
        return speed;
    }

    public static void main(String[] args) {
        getSpeedInfo(1000, 60);
        getSpeedInfo(7000, 40);
    }
}

