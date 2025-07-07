package chapters.twenty_one.concurrency.tasks.task_34;

import chapters.fifteen.generics.generators.BasicGenerator;
import chapters.twenty_one.concurrency.semaphore.Fat;

import java.util.List;
import java.util.concurrent.*;

public class ExchangerDemo {
    static int size = 10;
    static int delayIsSec = 2;

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 1)
            size = Integer.parseInt(args[0]);
        if (args.length > 1)
            delayIsSec = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<IPhone>> exchanger = new Exchanger<>();
        List<IPhone>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<IPhone>(exchanger, BasicGenerator.create(IPhone.class), producerList));
        exec.execute(new ExchangerConsumer<IPhone>(exchanger, consumerList));
        TimeUnit.SECONDS.sleep(delayIsSec);
        exec.shutdownNow();
    }
}
