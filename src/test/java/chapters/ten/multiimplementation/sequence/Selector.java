package chapters.ten.multiimplementation.sequence;

public interface Selector {
    boolean end();
    Object current();
    void next();
}
