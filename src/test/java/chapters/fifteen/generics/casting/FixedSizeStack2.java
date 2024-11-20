package chapters.fifteen.generics.casting;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeStack2<T> {
    private int size;
    private List<T> list;
    private int index;

    public FixedSizeStack2(int size) {
        this.size = size;
        this.list = new ArrayList<>(size);
    }

    public void push(T element) {
        if (index  < size) {
            list.add(index++, element);
        } else {
            throw new RuntimeException("Collection is full. Element cannot be added: " + element);
        }
    }

    public T pop() {
        if (index > 0) {
            return list.get(--index);
        } else {
            throw new RuntimeException("Collection is empty");
        }
    }
}
