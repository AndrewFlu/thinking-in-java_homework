package chapters.six.packageprivate;

import static net.midview.Print.print;

public class InnerEngineTestDrive {
    public static void main(String[] args) {
        Engine audiEngine = new BenzineEngine("CCZA");
        Engine bmwEngine = new DieselEngine("M47");

        print(String.format("Auidi engine: %s", audiEngine.getModel()));
        print(String.format("BMW engine: %s", bmwEngine.getModel()));

        print(String.format("BMW engine type: %s", bmwEngine.engineType));
        print(String.format("Audi engine type: %s", audiEngine.engineType));
    }
}
