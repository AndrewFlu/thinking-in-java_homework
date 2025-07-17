package chapters.twenty_one.concurrency.tasks.task_38.house_builder;

public class House {
    private final int id;
    private boolean
            walls = false,
            windows = false,
            roof = false,
            floors = false;

    public House(int id) {
        this.id = id;
    }

    public House() {
        id = -1;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void addWalls() {
        walls = true;
    }

    public synchronized void addWindows() {
        windows = true;
    }

    public synchronized void addRoof() {
        roof = true;
    }

    public synchronized void addFloors() {
        floors = true;
    }

    @Override
    public String toString() {
        return "House " + id + ": " +
                "[" +
                "walls: " + walls + ", " +
                "windows: " + windows + ", " +
                "roof: " + roof + ", " +
                "floors: " + floors +
                ']';
    }
}
