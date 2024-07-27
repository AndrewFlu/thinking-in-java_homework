package chapters.seven.inheritance;

import chapters.seven.inheritance.inner.Vehicle;

public class Bicycle extends Vehicle {
    public Bicycle() {
        super("велосипед");
    }

    public void stop() {
        System.out.println("Велосипед останавливается");
        super.stop();
    }
}
