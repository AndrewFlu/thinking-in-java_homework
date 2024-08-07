package chapters.nine.interfaceexamples.randomchars;

import java.util.Scanner;

public class RandomCharsTestDrive {
    public static void main(String[] args) {
        Readable readable = new RandomCharsAdapter(5);
        Scanner scanner = new Scanner(readable);
        while (scanner.hasNext()) {
            System.out.println(scanner.next() + " ");
        }
    }
}
