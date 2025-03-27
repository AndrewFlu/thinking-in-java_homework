package chapters.sixteen.arrays.comparing;

import java.util.Arrays;

import static net.mindview.utils.Print.print;

public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[5];
        int[] a2 = new int[5];
        Arrays.fill(a1, 7);
        Arrays.fill(a2, 7);
        print("a1 == a2 : " + Arrays.equals(a1, a2));

        a2[1] = 15;
        print("a1 == a2 : " +Arrays.equals(a1, a2));

        String[] s1 = new String[5];
        Arrays.fill(s1, "Hi");
        String[] s2 = {
                "Hi",
                "Hi",
                "Hi",
                "Hi",
                "Hi",
        };
        print("s1 == s2 : " +Arrays.equals(s1, s2));
    }
}
