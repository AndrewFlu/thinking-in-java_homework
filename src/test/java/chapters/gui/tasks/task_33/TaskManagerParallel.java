package chapters.gui.tasks.task_33;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskManagerParallel<R, C extends Callable<R>> extends ArrayList<TaskManagerParallel.TaskItem<R, C>> {
    private ExecutorService exec = Executors.newCachedThreadPool();

    public void add(C task) {
        add(new TaskItem<R, C>(exec.submit(task), task));
    }

    public List<R> getResults() {
        Iterator<TaskItem<R, C>> items = iterator();
        List<R> results = new ArrayList<>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            if (item.future.isDone()) {
                try {
                    results.add(item.future.get());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                items.remove();
            }
        }
        return results;
    }

    public List<String> purge() {
        Iterator<TaskItem<R, C>> items = iterator();
        List<String> results = new ArrayList<>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            // Сохранить завершённые задачи для вывода информации о результатах
            if (!item.future.isDone()) {
                results.add("Cancelling: " + item.task);
                item.future.cancel(true); // Возможно прерывание
                items.remove();
            }
        }
        return results;
    }

    /**
     * Объект Future и объект Callable, который его создаёт
     *
     * Он необходим, т.к. по умолчанию, задача не будет доступной в момент обращения к Future , потому что
     * объект задачи может прекратить своё существование на момент получения результата от Future.
     * Здесь же задача сохраняется.
     */
    public static class TaskItem<R, C extends Callable<R>> {

        public final Future<R> future;
        public final C task;

        public TaskItem(Future<R> future, C task) {
            this.future = future;
            this.task = task;
        }
    }
}