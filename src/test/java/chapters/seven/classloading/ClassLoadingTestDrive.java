package chapters.seven.classloading;

import static net.midview.Print.print;

public class ClassLoadingTestDrive {
    public static void main(String[] args) {
        ClassA a1 = new ClassA("A1");
        ClassA a2 = new ClassA("A2");

        print(a1.name);
        print(a2.name);
    }
}
