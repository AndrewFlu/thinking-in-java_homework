package chapters.ten.anonymous.shaker;

public class StringShaker {
    public String shake(String s) {
        char[] charArray = s.toCharArray();
        char[] target = new char[charArray.length];
        for (int i = 0; i <= charArray.length - 2; i += 2) {
            char first = charArray[i];
            char second = charArray[i + 1];
            target[i] = second;
            target[i + 1] = first;
        }
        if (charArray.length % 2 != 0) {
            target[target.length - 1] = charArray[charArray.length - 1];
        }

        return new String(target);
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
