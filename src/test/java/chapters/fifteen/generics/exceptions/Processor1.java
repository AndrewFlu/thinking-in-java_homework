package chapters.fifteen.generics.exceptions;

import java.util.List;

public class Processor1 implements IProcessor<String, Failure1> {
    static int count = 3;

    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1) {
            resultCollector.add("Yo!");
        } else {
            resultCollector.add("Common!");
        }
        if (count < 0) {
            throw new Failure1();
        }
    }
}
