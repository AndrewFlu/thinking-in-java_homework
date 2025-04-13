package chapters.nineteen.enums.multiple_dispatching.by_classes;

public class Rock implements Item {
    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.LOOSE;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.DRAW;
    }

    public String toString() {
        return "Rock";
    }
}
