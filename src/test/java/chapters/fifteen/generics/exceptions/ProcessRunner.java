package chapters.fifteen.generics.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ProcessRunner<T, E extends Exception> extends ArrayList<IProcessor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<T>();
        for (IProcessor<T, E> processor : this) {
            processor.process(resultCollector);
        }

        return resultCollector;
    }
}
