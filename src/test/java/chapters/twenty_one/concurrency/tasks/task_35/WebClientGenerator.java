package chapters.twenty_one.concurrency.tasks.task_35;

import java.util.Random;
import java.util.concurrent.TimeUnit;

// Случайное добавление web-клиентов в очередь
class WebClientGenerator implements Runnable {

    private WebClientsPool webClientsPool;
    private static Random rand = new Random(47);

    public WebClientGenerator(WebClientsPool webClientsPool) {
        this.webClientsPool = webClientsPool;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                webClientsPool.put(new WebClient(rand.nextInt(1_000)));
            }
        } catch (InterruptedException e) {
            System.out.println("WebClientGenerator interrupted");
        }
        System.out.println("WebClientGenerator terminating");
    }
}
