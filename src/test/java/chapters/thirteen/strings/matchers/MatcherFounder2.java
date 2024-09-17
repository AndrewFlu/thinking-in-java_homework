package chapters.thirteen.strings.matchers;

import java.util.Formatter;
import java.util.regex.Pattern;

public class MatcherFounder2 {
    public static void main(String[] args) {
        String s = "Arline ate eight apples and one orange while Anita hadn't any";

        Formatter formatter = new Formatter(System.out);
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        formatter.format("Matches? — %b. Регулярное выражение: %s\n", Pattern.compile(regex).matcher(s).matches(), regex);
    }
}
