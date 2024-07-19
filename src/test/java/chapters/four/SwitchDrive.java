package chapters.four;

import static net.midview.Print.print;

public class SwitchDrive {

    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            switch (i) {
                case 0: print("zero");
                    break;
                case 1: print("one");
                    break;
                case 2: print("two");
                    break;
                case 3: print("three");
                    break;
                case 4: print("four");
                    break;
                case 5: print("five");
                    break;
                default: print("only digits in [0 - 5]");
            }
        }
    }
}
