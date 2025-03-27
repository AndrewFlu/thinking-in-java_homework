package chapters.five;

import static net.mindview.utils.Print.print;

public class StaticInitialization {
    private static String brand = "BMW";
    private static String model;
    static {
        System.out.println("Вызов статического блока инициации");
        model = "f25";
    }

    public static void printCarInfo() {
        print(brand);
        print(model);
    }
}

class StaticTestDrive {
    public static void main(String[] args) {
        StaticInitialization.printCarInfo();
    }
}
