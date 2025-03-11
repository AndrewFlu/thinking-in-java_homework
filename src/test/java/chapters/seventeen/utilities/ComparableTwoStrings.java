package chapters.seventeen.utilities;

import java.util.Comparator;

public class ComparableTwoStrings implements Comparable<ComparableTwoStrings> {
    private String first;
    private String second;

    public static final Comparator<ComparableTwoStrings> SECOND_COMPARATOR = new SecondComparator();

    public ComparableTwoStrings(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " & " + second;
    }

    @Override
    public int compareTo(ComparableTwoStrings o) {
        return first.compareTo(o.first);
    }

    public static class SecondComparator implements Comparator<ComparableTwoStrings> {

        @Override
        public int compare(ComparableTwoStrings o1, ComparableTwoStrings o2) {
            return o1.second.compareTo(o2.second);
        }
    }
}
