package chapters.twenty_one.concurrency.tasks.task_34;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerConsumer<T> implements Runnable {

    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value; // отключаем оптимизацию поля

    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x; // Выборка значения
                    holder.remove(x); // Возможно для CopyOnWriteArrayList
                }
            }
        } catch (InterruptedException e) {
            // Допустимый способ выхода
        }
        System.out.println("Final value: " + value);
    }
}
