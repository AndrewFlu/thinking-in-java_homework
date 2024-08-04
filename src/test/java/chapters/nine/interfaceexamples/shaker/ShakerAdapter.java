package chapters.nine.interfaceexamples.shaker;

import chapters.nine.interfaceexamples.processors.Processor;

public class ShakerAdapter implements Processor {
    private final StringShaker shaker;

    public ShakerAdapter(StringShaker shaker) {
        this.shaker = shaker;
    }

    @Override
    public String name() {
        return shaker.getName();
    }

    @Override
    public String process(Object input) {
        return shaker.shake((String)input);
    }
}
