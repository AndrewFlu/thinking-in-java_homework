package chapters.nine.interfaceexamples.inheritance;

public class Audi extends VagGroup implements ICar {
    @Override
    public String getColor() {
        return "Red";
    }

    @Override
    public boolean isAllWheelDrive() {
        return true;
    }

    @Override
    public DriveType getDriveType() {
        return DriveType.ALL;
    }

    @Override
    public double getVolume() {
        return 1.8;
    }

    @Override
    public FuelType getType() {
        return FuelType.BENZINE;
    }

    @Override
    public String getBrand() {
        return getClass().getSimpleName();
    }

    @Override
    public String getModel() {
        return "A6 — All Road";
    }
}
