package chapters.fifteen.generics.casting;

public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> stringFixedSizeStack = new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            stringFixedSizeStack.push(s);
        }

        for (int i = 0; i < SIZE; i++) {
            String s = stringFixedSizeStack.pop();
            System.out.println(s + " ");
        }
    }
}
