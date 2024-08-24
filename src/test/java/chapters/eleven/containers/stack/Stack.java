package chapters.eleven.containers.stack;

import java.util.LinkedList;

/**
 * Реализует очередь (стек) по методу LIFO (Last In First Out)
 * @param <T> обобщённый параметр
 */
public class Stack<T> {
    private final LinkedList<T> storage = new LinkedList<>();

    /**
     * Добавляет элемент в начало очереди
     */
    public void push(T element) {
        storage.addFirst(element);
    }

    /**
     * Проверяет очередь на наличие элементов
     * @return true если очередь пуста
     */
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    /**
     * Возвращает первый элемент в очереди, с удалением элемента
     * @return Возвращает первый элемент с типом <T>
     */
    public T pop() {
        return storage.removeFirst();
    }

    /**
     * Извлекает первый элемент из очереди, без удаления
     * @return Первый элемент в очереди
     */
    public T peek() {
        return storage.getFirst();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}