package chapters.seventeen.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class FastTraversalLinkedList<E> {
    private ArrayList<E> arrayList = new ArrayList<>();
    private LinkedList<E> linkedList = new LinkedList<>();

    private LinkedList<E> toLinkedList(ArrayList<E> aList) {
        linkedList.clear();
        linkedList.addAll(aList);
        aList.clear();

        return linkedList;
    }

    private ArrayList<E> toArrayList(LinkedList<E> lList) {
        arrayList.clear();
        arrayList.addAll(lList);
        lList.clear();

        return arrayList;
    }

    public int size() {
        return Math.max(arrayList.size(), linkedList.size());
    }

    public void clear() {
        if (arrayList.size() < linkedList.size())
            linkedList.clear();
        else
            toLinkedList(arrayList).clear();
    }

    public void add(E e) {
        if (arrayList.size() < linkedList.size())
            linkedList.add(e);
        else
            toLinkedList(arrayList).add(e);
    }

    public void add(int index, E e) {
        if (arrayList.size() < linkedList.size())
            linkedList.add(index, e);
        else
            toLinkedList(arrayList).add(index, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        if(arrayList.size() < linkedList.size())
            return linkedList.addAll(collection);
        else
            return toLinkedList(arrayList).addAll(collection);
    }

    public E get(int index) {
        if (linkedList.size() < arrayList.size())
            return arrayList.get(index);
        else
            return toArrayList(linkedList).get(index);
    }

    public Iterator<E> iterator() {
        if (linkedList.size() < arrayList.size())
            return arrayList.iterator();
        else
            return linkedList.iterator();
    }

    public void addFirst(E e) {
        if (arrayList.size() < linkedList.size())
            linkedList.addFirst(e);
        else
            toLinkedList(arrayList).addFirst(e);
    }
}
