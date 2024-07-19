package chapters.five.overloading.chapters.five;

import static net.midview.Print.print;

public class DefaultConstructor {

    public DefaultConstructor() {
        print("MacBook is awesome!");
    }

    public DefaultConstructor(String agree) {
        this();
        print(agree);
    }
}
class Test {
    public static void main(String[] args) {
        new DefaultConstructor();
        print("");
        new DefaultConstructor("Yass!");
    }
}
