package chapters.fifteen.generics.sets;

import java.util.EnumSet;
import java.util.Set;

import static chapters.fifteen.generics.sets.CatProperties.*;
import static chapters.fifteen.generics.sets.Sets.*;
import static net.midview.Print.print;


public class CatPropertiesSets {
    public static void main(String[] args) {
        Set<CatProperties> dzemProperties = EnumSet.range(GRAY, PUFFY);
        Set<CatProperties> sansaProperties = EnumSet.range(PUFFY, GRACIES);

        print("Dzem properties: " + dzemProperties);
        print("Sansa properties: " + sansaProperties);

        print("Yana cats have properties: " + union(dzemProperties, sansaProperties));
        print("Dzem has differencies: " + difference(dzemProperties, sansaProperties));
        print("Sansa has differencies: " + difference(sansaProperties, dzemProperties));
        print("Cats has unique properties: " + complement(sansaProperties, dzemProperties));
    }
}
