package chapters.twenty_one.concurrency.tasks.task_29;

public class Sandwich {
    private Toast top, bottom;
    private final int id;

    public Sandwich(Toast top, Toast bottom, int id) {
        this.id = id;
        this.bottom = bottom;
        this.top = top;
    }

    public Toast getTop() {
        return top;
    }

    public Toast getBottom() {
        return bottom;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Sandwich " + id + ": top: " + top + ", bottom: " + bottom;
    }
}
