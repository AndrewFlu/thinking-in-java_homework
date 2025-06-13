package chapters.twenty_one.concurrency.tasks.task_24;

public class AppleManufacture implements Runnable {
    private AppleStore store;
    private int count = 0;

    protected int getCount() {
        return count;
    }
    public AppleManufacture(AppleStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                while (count < 50) {
                    IPhone iPhone = new IPhone(++count);
                    if (store.storage.offer(iPhone)) {
                        System.out.println("Завод изготовил " + iPhone);
                        // уведомить потребителя, что товар изготовлен
                        synchronized (store.appleClient) {
                            store.appleClient.notifyAll();
                        }
                        // на складе произваодства модно дерджать только 10 телефонов
                        // иначе - ждать освобождения товарного запаса
                        synchronized (this) {
                            while (!(store.storage.size() < 10)) {
                                wait();
                            }
                        }
                    }
                }

                // stop production after 100 items
                System.out.println("Остановка производства. \nВсего произведено " + count + " шт. iPhone");
                store.executor.shutdownNow();
            } catch (InterruptedException e) {
                System.out.println("Производство техники Apple приостановлено");
            }
        }
    }
}
