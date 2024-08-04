package chapters.nine.interfaceexamples.processors;

public interface Processor {
    String name();

    Object process(Object input);
}
