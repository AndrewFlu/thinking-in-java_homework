package chapters.nineteen.enums.multiple_dispatching.by_enummap;

import chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome;
import chapters.nineteen.enums.multiple_dispatching.by_enums.Competitor;
import chapters.nineteen.enums.multiple_dispatching.by_enums.RoShamBo;

import java.util.EnumMap;

import static chapters.nineteen.enums.multiple_dispatching.by_classes.Outcome.*;

public enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER,
    SCISSORS,
    ROCK;

    static final EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<>(RoShamBo5.class);

    static {
        for (RoShamBo5 it : RoShamBo5.values())
            table.put(it, new EnumMap<>(RoShamBo5.class));
        initRow(PAPER, DRAW, LOOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOOSE);
        initRow(ROCK, LOOSE, WIN, DRAW);
    }

    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    @Override
    public Outcome complete(RoShamBo5 it) {
        return table.get(this).get(it);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }
}

