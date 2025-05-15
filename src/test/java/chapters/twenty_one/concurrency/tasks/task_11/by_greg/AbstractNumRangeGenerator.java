package chapters.twenty_one.concurrency.tasks.task_11.by_greg;

// non-task, non-Runnable, can be canceled
public abstract class AbstractNumRangeGenerator {
    private volatile boolean canceled = false;

    public abstract int[] next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
