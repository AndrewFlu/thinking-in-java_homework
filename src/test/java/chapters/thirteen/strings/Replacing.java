package chapters.thirteen.strings;

import static net.mindview.utils.Print.print;

public class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        print(s.replaceFirst("f\\w+", "located"));
        print(s.replaceAll("strawberry|tree|heering", "banana"));
        print(s.replaceAll("[aeiouy]", "_"));
    }
}
