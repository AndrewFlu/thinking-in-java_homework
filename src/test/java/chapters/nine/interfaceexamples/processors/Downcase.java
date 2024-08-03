package chapters.nine.interfaceexamples.processors;

public class Downcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toLowerCase();
    }
}
