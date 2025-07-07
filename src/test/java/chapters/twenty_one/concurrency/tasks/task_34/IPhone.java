package chapters.twenty_one.concurrency.tasks.task_34;

import java.util.Random;

public class IPhone {
    private String name;
    private Random random = new Random();

    public IPhone() {
        name = "iPhone " + random.nextInt(4, 16);
    }

    @Override
    public String toString() {
        return name;
    }
}
