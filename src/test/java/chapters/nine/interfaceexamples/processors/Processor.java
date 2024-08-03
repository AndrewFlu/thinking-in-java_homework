package chapters.nine.interfaceexamples.processors;

public class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}
