package chapters.thirteen.strings.split;

import java.util.Arrays;
import java.util.regex.Pattern;

import static net.midview.Print.print;

public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual!!use!!of exclamation!!points";

        String[] split = Pattern.compile("!!").split(input);
        print(Arrays.toString(split));

        String[] limitedSplit = Pattern.compile("!!").split(input, 3);
        print(Arrays.toString(limitedSplit));
    }
}
