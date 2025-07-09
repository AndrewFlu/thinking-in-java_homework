package chapters.twenty_one.concurrency.tasks.task_35;

import java.util.concurrent.TimeUnit;

class WebServer implements Runnable, Comparable<WebServer> {

    private static int counter = 0;
    private final int id = counter++;
    // web-клиенты, обслуженные за сессию
    private int webClientsServed = 0;
    private WebClientsPool webClientsPool;
    private boolean isWebClientsServing = true;

    public WebServer(WebClientsPool webClientsPool) {
        this.webClientsPool = webClientsPool;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                WebClient webClient = webClientsPool.take();
                // serve web-client (till session time exist)
                TimeUnit.MILLISECONDS.sleep(webClient.getSessionTime());

                synchronized (this) {
                    webClientsServed++;
                    while (!isWebClientsServing)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminating");
    }

    public synchronized void doSomethingElse() {
        webClientsServed = 0;
        isWebClientsServing = false;
    }

    public synchronized void serveWebClientsPool() {
        assert !isWebClientsServing : "already serving: " + this;
        isWebClientsServing = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "WebServer: " + id + " ";
    }

    public String shortString() {
        return "WS" + id;
    }

    // Используется приоритетной очередью
    @Override
    public synchronized int compareTo(WebServer other) {
        return Integer.compare(webClientsServed, other.webClientsServed);
    }
}
