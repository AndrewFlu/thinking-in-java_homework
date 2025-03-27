package chapters.five;

import static net.mindview.utils.Print.print;

public class StringArray {
    public static void main(String[] args) {
        String[] stringArray = {
                "MacBook",
                "is",
                "awesome",
                "!"
        };

        for (String s : stringArray) {
            print(s);
        }
    }
}
