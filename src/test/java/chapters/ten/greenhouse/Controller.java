package chapters.ten.greenhouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Вместе в классом Event составляет систему управления общего характера
 */
public class Controller {
    private List<Event> eventList = new ArrayList<Event>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (!eventList.isEmpty()) {
            // создать копию, чтобы избежать модификации списка
            // во время выборки элементов
            for (Event e : new ArrayList<Event>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }

        }
    }
}
