package chapters.nine.interfaceexamples.processors;

public class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase(); // ковариантный возвращаемый тип
    }
}
