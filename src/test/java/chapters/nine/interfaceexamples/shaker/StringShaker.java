package chapters.nine.interfaceexamples.shaker;

public class StringShaker {
    public static String shake(String s) {
        char[] charArray = s.toCharArray();
        char[] target = new char[charArray.length];
        for (int i = 0; i <= charArray.length - 2; i += 2) {
            char first = charArray[i];
            char second = charArray[i + 1];
            target[i] = second;
            target[i + 1] = first;
        }

        return new String(target);
    }
}
