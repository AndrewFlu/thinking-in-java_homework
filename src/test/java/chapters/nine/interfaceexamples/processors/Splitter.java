package chapters.nine.interfaceexamples.processors;

import java.util.Arrays;

public class Splitter extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
