package chapters.nineteen.enums.enummap;

import chapters.nineteen.enums.enumset.AlarmPoint;

import java.util.EnumMap;
import java.util.Map;

import static chapters.nineteen.enums.enumset.AlarmPoint.*;
import static net.mindview.utils.Print.print;

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoint, Command> em = new EnumMap<>(AlarmPoint.class);
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                print("Kitchen fire!");
            }
        });

        em.put(BATHROOM, new Command() {
            @Override
            public void action() {
                print("Bathroom alert!");
            }
        });

        for (Map.Entry<AlarmPoint, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }

        try { // if there is no value for a particular key
            em.get(OFFICE1).action();
        } catch (Exception e) {
            print(e);
        }
    }
}
