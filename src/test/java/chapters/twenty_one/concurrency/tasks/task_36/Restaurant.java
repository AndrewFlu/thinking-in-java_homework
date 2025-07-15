package chapters.twenty_one.concurrency.tasks.task_36;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Restaurant implements Runnable {
    private List<WaitPerson> waitPersons = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    BlockingQueue<OrderTicket> orders = new LinkedBlockingQueue<>();
    private List<Table> tables;

    public Restaurant(ExecutorService exec, int nChefs, int nWaitPersons, List<Table> tables) {
        this.exec = exec;
        for (int i = 0; i < nWaitPersons; i++) {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            exec.execute(waitPerson);
        }
        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
        this.tables = tables;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // приходит новый посетитель, ему назначется официант и стол:
                WaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));

                Customer c = new Customer(wp, tables.get(rand.nextInt(tables.size())));
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Работа ресторана прервана");
        }
        System.out.println("Ресторан закрывается");
    }
}
