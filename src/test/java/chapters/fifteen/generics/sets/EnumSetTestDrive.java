package chapters.fifteen.generics.sets;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class EnumSetTestDrive {
    public static void main(String[] args) {
        EnumSet<?> catPropSet = EnumSet.allOf(CatProperties.class);
        System.out.println(catPropSet);
        EnumSet<CatProperties> range = EnumSet.range(CatProperties.HUNGRY, CatProperties.PUFFY);
        Set<CatProperties> catSet = new HashSet<>(range);
        System.out.println(catSet);

        EnumSet rangeEnumSet = EnumSet.copyOf(catSet);
        System.out.println(rangeEnumSet);
    }
}
