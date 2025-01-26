package chapters.eleven.containers.queue;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem arg) {
            if (primary > arg.primary)
                return +1;
            if (primary == arg.primary)
                if (secondary > arg.secondary)
                    return +1;
                else if (secondary == arg.secondary)
                    return 0;
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }
    }

    public void add(String toDo, char priority, int secondary) {
        super.add(new ToDoItem(priority, secondary, toDo));
    }

    // test-drive
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Read 'Web security'", 'A', 3);
        toDoList.add("Read 'Thinking in Java'", 'A', 2);
        toDoList.add("Cover the flour", 'C', 1);

        while (!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }
}
