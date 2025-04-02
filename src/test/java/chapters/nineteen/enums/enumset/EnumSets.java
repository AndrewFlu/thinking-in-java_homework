package chapters.nineteen.enums.enumset;

import java.util.EnumSet;

import static chapters.nineteen.enums.enumset.AlarmPoint.*;
import static net.mindview.utils.Print.print;

public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoint> points = EnumSet.noneOf(AlarmPoint.class); // пустое множество
        points.add(BATHROOM);
        print(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points = EnumSet.allOf(AlarmPoint.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);

        points = EnumSet.complementOf(points);
        print(points);
    }
}
