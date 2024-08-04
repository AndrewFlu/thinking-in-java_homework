package chapters.nine.interfaceexamples.processors;

import java.util.Arrays;

public class Splitter implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
