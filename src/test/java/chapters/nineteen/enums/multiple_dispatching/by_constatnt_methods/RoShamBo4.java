package chapters.nineteen.enums.multiple_dispatching.by_constatnt_methods;

import chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome;
import chapters.nineteen.enums.multiple_dispatching.by_enums.Competitor;
import chapters.nineteen.enums.multiple_dispatching.by_enums.RoShamBo;

public enum RoShamBo4 implements Competitor<RoShamBo4> {
    ROCK {
        @Override
        public Outcome complete(RoShamBo4 opponent) {
            return complete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        @Override
        public Outcome complete(RoShamBo4 opponent) {
            return complete(PAPER, opponent);
        }
    },
    PAPER {
        @Override
        public Outcome complete(RoShamBo4 opponent) {
            return complete(ROCK, opponent);
        }
    };

    Outcome complete(RoShamBo4 looser, RoShamBo4 opponent) {
        return ((opponent == this) ? Outcome.DRAW : ((opponent == looser) ? Outcome.WIN : Outcome.LOOSE));
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}

