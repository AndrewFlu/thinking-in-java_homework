package chapters.nineteen.enums.multiple_dispatching.by_classes;

public interface Item {
    Outcome complete(Item it);
    Outcome eval (Paper p);
    Outcome eval (Scissors s);
    Outcome eval (Rock r);
}
