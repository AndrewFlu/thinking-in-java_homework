package chapters.twelve.exceptions.finallyblock.multiexception;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int washerLevel;
    private boolean checkEngine;
    private boolean checkIgnition;

    public Car(String model, int washerLevel, boolean checkEngine, boolean checkIgnition) {
        this.model = model;
        this.washerLevel = washerLevel;
        this.checkEngine = checkEngine;
        this.checkIgnition = checkIgnition;
    }

    public void checkCar() {
        List<Exception> errors = new ArrayList<>();
        if (washerLevel < 5) errors.add(new WasherException());
        if (checkEngine) errors.add(new EnginException());
        if (checkIgnition) errors.add(new IgnitionException());

        if (errors.isEmpty()) {
            System.out.println("Автомобиль " + model + " исправен");
            System.out.println();
        } else {
            System.out.println("Автомобиль " + model + " неисправен: ");
            for (Exception e : errors) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
}
