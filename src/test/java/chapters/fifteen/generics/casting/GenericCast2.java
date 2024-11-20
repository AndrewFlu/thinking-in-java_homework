package chapters.fifteen.generics.casting;

public class GenericCast2 {
    private static final int SIZE = 5;

    public static void main(String[] args) {
        FixedSizeStack2<String> stringFixedSizeStack = new FixedSizeStack2<>(SIZE);
        for (String s : "A B C D E".split(" ")) {
            stringFixedSizeStack.push(s);
        }

        try {
            stringFixedSizeStack.push("Overall element");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        for (int i = 0; i < SIZE; i++) {
            String s = stringFixedSizeStack.pop();
            System.out.println(s + " ");
        }
    }
}
