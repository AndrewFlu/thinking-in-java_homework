package chapters.nine.interfaceexamples.inheritance;

public interface IDrive {

    boolean isAllWheelDrive();

    DriveType getDriveType();

    enum DriveType {
        REAR,
        FRONT,
        ALL,
    }
}
