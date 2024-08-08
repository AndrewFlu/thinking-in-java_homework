package chapters.ten.sequence;

public interface Selector {
    boolean end();
    Object current();
    void next();
}
