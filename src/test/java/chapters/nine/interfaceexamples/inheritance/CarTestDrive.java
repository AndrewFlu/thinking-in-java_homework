package chapters.nine.interfaceexamples.inheritance;

public class CarTestDrive {
    public static void main(String[] args) {
        Audi audiAllRoad = new Audi();
        printModel(audiAllRoad);
        printVolume(audiAllRoad);
        printEngineType(audiAllRoad);
        printColor(audiAllRoad);
        printWheelDriveType(audiAllRoad);
    }

    private static void printWheelDriveType(IDrive drive) {
        System.out.println(drive.getDriveType());
    }

    private static void printColor(ICar car) {
        System.out.println(car.getColor());
    }

    private static void printVolume(IEngine engine) {
        System.out.println(String.format("Объём двигателя: %s л.", engine.getVolume()));
    }
    private static void printEngineType(IEngine engine) {
        System.out.println(String.format("Тип двигателя: %s", engine.getType().getName()));
    }

    private static void printModel(IManufacturer manufacturer) {
        System.out.println(manufacturer.getModel());
    }
}
