package chapters.eleven.containers.list.iterator.sequence;

public interface Selector {
    boolean end();
    Object current();
    void next();
}
