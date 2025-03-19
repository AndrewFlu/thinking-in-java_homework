package chapters.eighteen.input_optput.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IOTask9 {
    public static List<String> read(String fileName) throws IOException {
        String s;
        List<String> result = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while ((s = bufferedReader.readLine()) != null)
            result.add(s);

        return result;
    }

    public static void main(String[] args) throws IOException {
        String fileName;
        if (args.length != 1)
            fileName = "example.txt";
        else fileName = args[0];
        List<String> readStrings = read(fileName);
        System.out.println("File data in reversed order and in capitalized manner...");
        LinkedList<String> ll = new LinkedList<>(readStrings);
        while (!ll.isEmpty()) {
            System.out.println(ll.pollLast().toUpperCase());
        }
    }
}
