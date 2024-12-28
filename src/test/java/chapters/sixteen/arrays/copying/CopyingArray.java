package chapters.sixteen.arrays.copying;

import java.util.Arrays;

import static net.midview.Print.print;

public class CopyingArray {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 15);
        Arrays.fill(j, 50);
        print("i = " + Arrays.toString(i));
        print("j = " + Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        print("i = " + Arrays.toString(i));
        print("j = " + Arrays.toString(j));

        int[] k = new int[5];
        Arrays.fill(k, 100);
        print("k = " + Arrays.toString(k));
        System.arraycopy(i, 0, k, 0, k.length);
        print("k = " + Arrays.toString(k));
        Arrays.fill(k, 50);
        print("k = " + Arrays.toString(k));
        System.arraycopy(k, 0, i, 0, k.length);
        print("i = " + Arrays.toString(i));
        // Objects:
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, 47);
        Arrays.fill(v, 99);
        print("u = " + Arrays.toString(u));
        print("v = " + Arrays.toString(v));

        System.arraycopy(v, 0, u, u.length / 2, v.length);
        print("u = " + Arrays.toString(u));
    }
}
