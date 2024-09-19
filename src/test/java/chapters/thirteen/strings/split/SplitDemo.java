package chapters.thirteen.strings.split;

import java.util.Arrays;

import static net.midview.Print.print;

public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual!!use!!of exclamation!!points";

        print(Arrays.toString(input.split("!!")));

        print(Arrays.toString(input.split("!!", 3)));
    }
}
