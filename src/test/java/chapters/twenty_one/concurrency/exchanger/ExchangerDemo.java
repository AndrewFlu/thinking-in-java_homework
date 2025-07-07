package chapters.twenty_one.concurrency.exchanger;

import chapters.fifteen.generics.generators.BasicGenerator;
import chapters.twenty_one.concurrency.semaphore.Fat;

import java.util.List;
import java.util.concurrent.*;

public class ExchangerDemo {
    static int size = 10;
    static int delayIsSec = 5;

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 1)
            size = Integer.parseInt(args[0]);
        if (args.length > 1)
            delayIsSec = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> exchanger = new Exchanger<>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<Fat>(exchanger, BasicGenerator.create(Fat.class), producerList));
        exec.execute(new ExchangerConsumer<Fat>(exchanger, consumerList));
        TimeUnit.SECONDS.sleep(delayIsSec);
        exec.shutdownNow();
    }
}
