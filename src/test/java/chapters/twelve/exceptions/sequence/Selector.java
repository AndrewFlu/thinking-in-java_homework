package chapters.twelve.exceptions.sequence;

public interface Selector {
    boolean end();
    Object current();
    void next();
}
