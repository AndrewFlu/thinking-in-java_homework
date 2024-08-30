package chapters.eleven.containers.adapter;

import java.util.Arrays;

public class AdapterMethodTestDrive {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("MacBook is awesome!".split(" ")));

        for (String s : ral) {
            System.out.println(s + " ");
        }
        System.out.println();
        for (String s : ral.reversed()) {
            System.out.println(s + " ");
        }
    }
}
