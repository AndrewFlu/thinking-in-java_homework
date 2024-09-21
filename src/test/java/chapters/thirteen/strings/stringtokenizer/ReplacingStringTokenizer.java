package chapters.thirteen.strings.stringtokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReplacingStringTokenizer {
    public static void main(String[] args) {
        String input = "MacBook is awesome!";

        StringTokenizer stoke = new StringTokenizer(input);
        System.out.println("StringTokenizer:");
        while (stoke.hasMoreElements()) {
            System.out.print(stoke.nextToken() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("String.split():");
        System.out.println(Arrays.toString(input.split(" ")));

        System.out.println();
        System.out.println("Scanner:");
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
    }
}
