package chapters.fifteen.generics.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ProcessRunner<T, E extends Exception, U extends Exception> extends ArrayList<IProcessor<T, E, U>> {
    List<T> processAll() throws E, U {
        List<T> resultCollector = new ArrayList<T>();
        for (IProcessor<T, E, U> processor : this) {
            processor.process(resultCollector);
        }

        return resultCollector;
    }
}
