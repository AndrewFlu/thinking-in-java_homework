package chapters.thirteen.strings;

import java.util.Arrays;

public class Splitting {
    public static String knights =
            "Then, when you have found the strawberry, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" "); // без специальных символов
        split("\\W"); //  по символам, не являющимися символами слов
        split("n\\W+"); // буква n, за котрой следуют символы, не являющиеся символами слов
    }
}
