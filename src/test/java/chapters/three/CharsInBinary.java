package chapters.three;

import static net.mindview.utils.Print.print;

public class CharsInBinary {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        for (Character ch : chars) {
            print(String.format("'%s' in binary = %s, in decimal = %s", ch, Integer.toBinaryString(ch), Character.getNumericValue(ch)));
        }
    }
}