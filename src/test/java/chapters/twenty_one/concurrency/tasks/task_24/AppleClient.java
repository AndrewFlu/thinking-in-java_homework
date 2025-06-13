package chapters.twenty_one.concurrency.tasks.task_24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AppleClient implements Runnable {

    private AppleStore store;
    private int consumed = 0;
    private Queue<IPhone> cart = new LinkedList<>();

    public AppleClient(AppleStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // нельзя продавать больше, чем произведено
                // иначе - ждать
                synchronized (this) {
                    while (!(cart.size() < store.appleManufacture.getCount())) {
                        wait();
                    }
                }

                // переместить товар с магазина в корзину
                if (cart.offer(store.storage.poll())) {
                    System.out.println("Куплен телефон : " + ++consumed);
                    synchronized (store.appleManufacture) {
                        store.appleManufacture.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Продажи прерваны");
            System.out.println("Всего куплено " + consumed  + " шт.");
        }
    }
}
