package chapters.twenty_one.concurrency.tasks.task_11.by_greg;

import java.util.Random;

public class NumRangeGenerator extends AbstractNumRangeGenerator {

    private int min = 0;
    private int max = 0;
    private Random random = new Random();

    @Override
    public int[] next() { // oops, method should be synchronised
        min = random.nextInt(100);
        max = random.nextInt(100);
        Thread.yield();

        if (min > max)
            max = min;
        int[] result = {min, max};

        return result;
    }

    public static void main(String[] args) {
        NumRangeChecker.test(new NumRangeGenerator());
    }
}
