package chapters.twenty_one.concurrency.tasks.task_29;

class Toast {
    public enum Status {DRY, JELLIED, PEANUT_BUTTERED}

    private Status status = Status.DRY;
    private final int id;

    public Toast(int idn) {
        id = idn;
    }

    public void peanutButter() {
        status = Status.PEANUT_BUTTERED;
    }

    public void jelly() {
        status = Status.JELLIED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Toast " + id + ": " + status;
    }
}
