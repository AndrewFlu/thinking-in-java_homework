package chapters.nineteen.enums.multiple_dispatching.by_array;

import chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome;
import chapters.nineteen.enums.multiple_dispatching.by_enums.Competitor;
import chapters.nineteen.enums.multiple_dispatching.by_enums.RoShamBo;

import static chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome.*;

public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER,
    SCISSORS,
    ROCK;

    private final Outcome[][] table = {
            {DRAW, LOOSE, WIN}, // PAPER
            {WIN, DRAW, LOOSE}, // SCISSORS
            {LOOSE, WIN, DRAW}, //ROCK
    };

    @Override
    public Outcome complete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
