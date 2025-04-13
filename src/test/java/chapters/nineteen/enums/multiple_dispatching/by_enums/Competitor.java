package chapters.nineteen.enums.multiple_dispatching.by_enums;

import chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome;

public interface Competitor<T extends Competitor<T>> {
    Outcome complete(T competitor);
}
