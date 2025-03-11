package chapters.seventeen.utilities;

import java.util.Comparator;

public class ComparableTwoStrings implements Comparable<ComparableTwoStrings> {
    private String first;
    private String second;

    public static final Comparator<ComparableTwoStrings> SECOND_COMPARATOR = new SecondComparator();
    public static final Comparator<ComparableTwoStrings> CASE_INSENSITIVE_ORDER_BY_FIRST_STRING = new CaseInsensitiveComparator();

    public ComparableTwoStrings(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "'" + first + " & " + second + "'";
    }

    @Override
    public int compareTo(ComparableTwoStrings o) {
        return first.compareTo(o.first);
    }

    static void printArray(ComparableTwoStrings[] sa) {
        System.out.print("(");
        for (int i = 0; i < sa.length; i++)
            System.out.print(sa[i] + ", ");
        System.out.println(sa[sa.length - 1] + ")");
    }

    public static class SecondComparator implements Comparator<ComparableTwoStrings> {

        @Override
        public int compare(ComparableTwoStrings o1, ComparableTwoStrings o2) {
            return o1.second.compareTo(o2.second);
        }
    }

    private static class CaseInsensitiveComparator implements Comparator<ComparableTwoStrings> {
        @Override
        public int compare(ComparableTwoStrings o1, ComparableTwoStrings o2) {
            return o1.first.compareToIgnoreCase(o2.first);
        }
    }
}
