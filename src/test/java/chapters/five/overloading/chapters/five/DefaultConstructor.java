package chapters.five.overloading.chapters.five;

import static net.midview.Print.print;

public class DefaultConstructor {
    public DefaultConstructor() {
        print("MacBook is awesome!");
    }
}
class Test {
    public static void main(String[] args) {
        new DefaultConstructor();
    }
}
