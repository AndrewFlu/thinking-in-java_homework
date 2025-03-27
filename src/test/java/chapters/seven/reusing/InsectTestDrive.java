package chapters.seven.reusing;

import static net.mindview.utils.Print.print;

public class InsectTestDrive {
    public static void main(String[] args) {
        print("Конструктор Beetle");
        Beetle b = new Beetle();
        print("Конструктор MayBeetle");
        Beetle mb = new MayBeetle();

    }
}