package chapters.twenty_one.concurrency.tasks.task_35;

import java.util.concurrent.ArrayBlockingQueue;

// Очередь web-клиентов умеет выводить своё состояние:
class WebClientsPool extends ArrayBlockingQueue<WebClient> {

    public WebClientsPool(int maxWebClientsSize) {
        super(maxWebClientsSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0)
            return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (WebClient webClient : this)
            result.append(webClient);
        return result.toString();
    }
}
