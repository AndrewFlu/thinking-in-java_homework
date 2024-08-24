package chapters.eleven.containers.linkedlist.greenhouse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Вместе в классом Event составляет систему управления общего характера
 */
public class Controller {
    private List<Event> eventList = new LinkedList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        // создать копию, чтобы избежать модификации списка
        // во время выборки элементов
        Iterator<Event> iterator = new LinkedList<>(eventList).iterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            if (event.ready()) {
                System.out.println(event);
                event.action();
                eventList.remove(event);
            }
        }
    }
}
