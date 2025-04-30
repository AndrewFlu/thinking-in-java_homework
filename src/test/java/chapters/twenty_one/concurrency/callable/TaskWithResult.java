package chapters.twenty_one.concurrency.callable;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private final int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult with id #" + id;
    }
}
