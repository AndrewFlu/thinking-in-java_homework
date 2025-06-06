package chapters.twenty_one.concurrency.tasks.task_18;

public class RunnableClass implements Runnable {

    @Override
    public void run() {
        new NoRunnable().sleep();
    }
}
