package chapters.twenty_one.concurrency.tasks.task_35;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class Balancer implements Runnable {

    private ExecutorService exec;
    private WebClientsPool webClients;
    private PriorityQueue<WebServer> workingWebServers = new PriorityQueue<>();
    private Queue<WebServer> availableServersPool = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random rand = new Random(47);

    public Balancer(ExecutorService e, WebClientsPool webClients, int adjustmentPeriod) {
        exec = e;
        this.webClients = webClients;
        this.adjustmentPeriod = adjustmentPeriod;
        // Начать с одного сервера
        WebServer webServer = new WebServer(webClients);
        exec.execute(webServer);
        workingWebServers.add(webServer);
    }

    public void adjustWebServersNumber() {
        // Система управления: изменяя числа, можно выявить
        // проблемы стабильности в управляющем механизме.
        // Если web-клиентов слишком много — добавить сервер:
        if (webClients.size() / workingWebServers.size() > 2) {
            // Если есть рабочие, но простаивающие сервера — включить один в работу:
            if (availableServersPool.size() > 0) {
                WebServer webServer = availableServersPool.remove();
                webServer.serveWebClientsPool();
                workingWebServers.offer(webServer);
                return;
            }
            // Если простаивающих серверов нет — добавить (создать) новый
            WebServer webServer = new WebServer(webClients);
            exec.execute(webServer);
            workingWebServers.add(webServer);
            return;
        }

        // Если очередь достаточно короткая — освободить сервер:
        if (workingWebServers.size() > 1 && webClients.size() / workingWebServers.size() < 2)
            reassignOneWebServer();
        // Если очереди нет — достаточно одного web-сервера:
        if (webClients.isEmpty())
            while (workingWebServers.size() > 1)
                reassignOneWebServer();
    }

    // Освободить web-сервер:
    private void reassignOneWebServer() {
        WebServer webServer = workingWebServers.poll();
        webServer.doSomethingElse();
        availableServersPool.offer(webServer);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustWebServersNumber();
                System.out.print(webClients + " {");
                for (WebServer webServer : workingWebServers)
                    System.out.print(webServer.shortString() + " ");
                System.out.println("}");
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminating");
    }

    public String toString() {
        return "WebServer ";
    }
}
