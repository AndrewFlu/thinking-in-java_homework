package chapters.twenty_one.concurrency.tasks.task_11;

public abstract class AbstractAccount implements ITransaction {

    private boolean active = true; // volatile

    public void setLocked() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }
}
