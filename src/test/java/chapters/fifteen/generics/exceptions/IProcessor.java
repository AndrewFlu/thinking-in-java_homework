package chapters.fifteen.generics.exceptions;

import java.util.List;

public interface IProcessor<T, E extends Exception, U extends Exception> {
    void process(List<T> resultCollector) throws E, U;
}
