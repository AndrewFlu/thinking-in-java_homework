package chapters.nineteen.enums.multiple_dispatching.by_classes;

public class Scissors implements Item{
    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.LOOSE;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.WIN;
    }

    public String toString() {
        return "Scissors";
    }
}
