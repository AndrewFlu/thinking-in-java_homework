package chapters.three;

import static net.mindview.utils.Print.print;

public class StringComparison {
    private static final String STR_CONST = "123";

    public static void logicOperations(String s1, String s2) {
        print(String.format("(%s == %s) is %s", s1, s2, s1 == s2));
        print(String.format("(%s != %s) is %s", s1, s2, s1 != s2));
//!        print(String.format("(!%s) is %s", s1, !s1));
//!        print(String.format("(%s < %s) is %s", s1, s2, s1 < s2));
//!        print(String.format("(%s <= %s) is %s", s1, s2, s1 <= s2));
//!        print(String.format("(%s > %s) is %s", s1, s2, s1 > s2));
//!        print(String.format("(%s >= %s) is %s", s1, s2, s1 >= s2));
        print(String.format("(%s.equals(%s)) is %s", s1, s2, s1.equals(s2)));
    }

    public static void main(String[] args) {
        logicOperations("MacBook", "Lenovo");
        print("");
        logicOperations("ANDREW", "andrew");
        print("");
        logicOperations("andrew", "andrew");
        print("");
        logicOperations("", "");
        print("");
        logicOperations(STR_CONST, "123");
        print("");
        logicOperations( "", null);
    }
}
