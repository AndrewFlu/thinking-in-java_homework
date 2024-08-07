package chapters.nine.interfaceexamples.fabrics.cycle;

public class CycleTestDrive {
    public static void main(String[] args) {
        ICycle monoWheel = new Unicycle();
        ICycle bicycle = new Bicycle();
        ICycle triCycle = new Tricycle();

        monoWheel.drive();
        bicycle.drive();
        triCycle.drive();
    }
}
