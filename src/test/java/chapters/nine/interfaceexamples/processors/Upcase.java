package chapters.nine.interfaceexamples.processors;

public class Upcase implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase(); // ковариантный возвращаемый тип
    }
}
