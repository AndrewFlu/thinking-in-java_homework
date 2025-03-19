package chapters.eighteen.input_optput.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IOTask10 {
    public static List<String> read(String fileName) throws IOException {
        String s;
        List<String> result = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while ((s = bufferedReader.readLine()) != null)
            result.add(s);

        return result;
    }

    public static LinkedList<String> read(String[] args) throws IOException {
        BufferedReader reader = null;
        LinkedList<String> lines = new LinkedList<>();
        List<String> wordsToSearch = Arrays.asList(args);
        wordsToSearch = wordsToSearch.subList(1, args.length);
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String s;
            while ((s = reader.readLine()) != null) {
                for (String string : wordsToSearch) {
                    if (s.toLowerCase().contains(string))
                        lines.add(s.toUpperCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return lines;
    }

    private static void usage() {
        System.out.println("Usage (args): ");
        System.out.println("filepath words (separated by space)");
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            usage();
            System.exit(1);
        }

        LinkedList<String> readStrings = read(args);
        while (!readStrings.isEmpty())
            System.out.println(readStrings.pollFirst());
    }
}
