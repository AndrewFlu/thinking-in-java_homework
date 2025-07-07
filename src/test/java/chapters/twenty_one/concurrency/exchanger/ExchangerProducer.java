package chapters.twenty_one.concurrency.exchanger;

import net.mindview.utils.Generator;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerProducer<T> implements Runnable {

    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchanger, Generator<T> generator, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(generator.next());
                }
                // полный список меняется с пустым
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            // Допустимый способ выхода
        }
    }
}
