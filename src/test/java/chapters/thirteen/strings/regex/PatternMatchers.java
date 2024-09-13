package chapters.thirteen.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchers {
    public static void main(String[] args) {
        String one = "MacBook is awesome!";
        String two = "MacBook is awesome.";
        String three = "MacBook is awesome";
        Pattern pattern = Pattern.compile("\\A([A-Z](\\w|\\W)*)+(\\.)$");
        Matcher matcher1 = pattern.matcher(one);
        Matcher matcher2 = pattern.matcher(two);
        Matcher matcher3 = pattern.matcher(three);

        System.out.println("One is " + matcher1.matches());
        System.out.println("Two is " + matcher2.matches());
        System.out.println("Three is " + matcher3.matches());
    }
}
