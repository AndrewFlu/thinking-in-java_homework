package chapters.two;

public class StorageTestDrive {
    public static void main(String[] args) {
        StorageController controller = new StorageController();
        int rusBytes = controller.storage("Макбук");
        int enBytes = controller.storage("Macbook");
        System.out.println("rusBytes - " + rusBytes);
        System.out.println("enBytes - " + enBytes);
    }
}
