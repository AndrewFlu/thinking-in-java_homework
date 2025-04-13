package chapters.nineteen.enums.multiple_dispatching.by_enums;

import chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome;

import static chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOOSE, WIN),
    SCISSORS(WIN, DRAW, LOOSE),
    ROCK(LOOSE, WIN, DRAW),
    ;

    private Outcome vPAPER, vSCISSORS, vROCK;

    RoShamBo2(Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        this.vPAPER = vPAPER;
        this.vSCISSORS = vSCISSORS;
        this.vROCK = vROCK;
    }

    public Outcome complete(RoShamBo2 it) {
        return switch (it) {
            case PAPER -> vPAPER;
            case SCISSORS -> vSCISSORS;
            case ROCK -> vROCK;
        };
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
