package chapters.twenty_one.concurrency.tasks.task_35;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Args: 5
public class WebClientsSimulation {
    static final int MAX_WEB_CLIENTS_COUNT = 50;
    static final int ADJUSTMENT_PERIOD = 1_000;

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        // Если очередь слишком длинная — клиенты не обслуживаются:
        WebClientsPool webClients = new WebClientsPool(MAX_WEB_CLIENTS_COUNT);
        exec.execute(new WebClientGenerator(webClients));
        // Балансировщик добаваляет и удалает серверы по мере необходимости:
        exec.execute(new Balancer(exec, webClients, ADJUSTMENT_PERIOD));
        if (args.length > 0) // Необязательный аргумент
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
