package chapters.nineteen.enums.multiple_dispatching.by_classes;

public class Paper implements Item{
    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.LOOSE;
    }

    public String toString() {
        return "Paper";
    }
}
