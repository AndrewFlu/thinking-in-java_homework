package chapters.eighteen.input_optput.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IOTask7 {
    public static List<String> read(String fileName) throws IOException {
        String s;
        List<String> result = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while ((s = bufferedReader.readLine()) != null)
            result.add(s);

        return result;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "example.txt";
        List<String> readStrings = read(fileName);
        System.out.println(readStrings);
        System.out.println("And reversed order...");
        LinkedList<String> ll = new LinkedList<>(readStrings);
        while (!ll.isEmpty()) {
            System.out.println(ll.pollLast());
        }
    }
}
