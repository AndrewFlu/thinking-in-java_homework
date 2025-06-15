package chapters.twenty_one.concurrency.tasks.task_25_26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    Meal meal;
    boolean cleaned = true;
    ExecutorService exec = Executors.newCachedThreadPool();

    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    BusBoy busBoy = new BusBoy(this);

    public Restaurant() {
        exec.execute(busBoy);
        exec.execute(waitPerson);
        exec.execute(chef);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
