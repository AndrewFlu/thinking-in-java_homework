package chapters.thirteen.strings.matchers;

import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFounder {
    public static void main(String[] args) {
        String s = "Java now has regular expressions";

        System.out.println(Pattern.matches("^Java", s));
        System.out.println(Pattern.matches("\\Breg.*", s));
        System.out.println(Pattern.matches("n.w\s +h(a|i)s", s));
        System.out.println(Pattern.matches("s?", s));
        System.out.println(Pattern.matches("s*", s));
        System.out.println(Pattern.matches("s+", s));
        System.out.println(Pattern.matches("s{4}", s));
        System.out.println(Pattern.matches("s{1}", s));
        System.out.println(Pattern.matches("s{0,3}", s));

        String[] regExs = {"^java", "\\Breg.*", "n.w\s +h(a|i)s", "s?"};
        Formatter formatter = new Formatter(System.out);
        System.out.println(s);
        for (String regEx : regExs) {
            formatter.format("Matches? %b. Regular expression = %s%n", s.matches(regEx), regEx);
        }
    }
}
