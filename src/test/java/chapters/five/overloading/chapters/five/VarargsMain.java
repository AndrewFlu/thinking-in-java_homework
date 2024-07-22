package chapters.five.overloading.chapters.five;

import static net.midview.Print.print;

public class VarargsMain {
    public static void main(String... args) {
        for (String s : args) {
            print(s);
        }
    }
}

class VarargsMainTestDrive {
    public static void main(String[] args) {
        VarargsMain.main(new String[]{"s1", "s2", "s3"});
        print("");
        VarargsMain.main(new String[]{new String("1"), new String("2"), String.valueOf(3)});
        print("");
        VarargsMain.main(new String ("one string"));
    }
}
