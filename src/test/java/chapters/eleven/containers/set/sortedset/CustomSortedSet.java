package chapters.eleven.containers.set.sortedset;

import chapters.sixteen.arrays.comparing.CustomObject;
import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.*;
import java.util.random.RandomGeneratorFactory;

public class CustomSortedSet<T> implements SortedSet<T> {
    private LinkedList<T> list;

    public CustomSortedSet(LinkedList<T> list) {
        this.list = list;
    }


    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return new CustomSortedSet<T>(new LinkedList<T>(list.subList(list.indexOf(fromElement), list.indexOf(toElement))));
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        return new CustomSortedSet<>(new LinkedList<>(list.subList(0, list.indexOf(toElement))));
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return new CustomSortedSet<>(new LinkedList<>(list.subList(list.indexOf(fromElement), size())));
    }

    @Override
    public T first() {
        return list.getFirst();
    }

    @Override
    public T last() {
        return getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return list.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        Collection<String> stringArray = Arrays.asList("ONE TWO THREE FOUR FIVE".split(" "));
        CustomSortedSet<String> customSortedSet = new CustomSortedSet<>(new LinkedList<>(stringArray));
        customSortedSet.add("Zero");
        System.out.println(customSortedSet);
    }
}
