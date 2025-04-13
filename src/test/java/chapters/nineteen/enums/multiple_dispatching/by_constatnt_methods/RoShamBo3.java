package chapters.nineteen.enums.multiple_dispatching.by_constatnt_methods;

import chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome;
import chapters.nineteen.enums.multiple_dispatching.by_enums.Competitor;
import chapters.nineteen.enums.multiple_dispatching.by_enums.RoShamBo;

import static chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome.*;


public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        @Override
        public Outcome complete(RoShamBo3 it) {
            return switch (it) {
                case PAPER -> DRAW;
                case SCISSORS -> LOOSE;
                case ROCK -> WIN;
            };
        }
    },
    SCISSORS {
        @Override
        public Outcome complete(RoShamBo3 it) {
            return switch (it) {
                case PAPER -> WIN;
                case SCISSORS -> DRAW;
                case ROCK -> LOOSE;
            };
        }
    },
    ROCK {
        @Override
        public Outcome complete(RoShamBo3 it) {
            return switch (it) {
                case PAPER -> LOOSE;
                case SCISSORS -> WIN;
                case ROCK -> DRAW;
            };
        }
    };

    public abstract Outcome complete(RoShamBo3 it);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }

}
