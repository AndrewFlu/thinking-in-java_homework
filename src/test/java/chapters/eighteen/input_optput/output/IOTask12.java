package chapters.eighteen.input_optput.output;

import chapters.eighteen.input_optput.input.BufferedInputFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IOTask12 {
    public static List<String> read(String fileName) throws IOException {
        String s;
        List<String> result = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while ((s = bufferedReader.readLine()) != null)
            result.add(s);

        return result;
    }

    public static void main(String[] args) throws IOException {
        String fileIn;
        String fileOut = "IOTask12Output.txt";

        if (args.length != 1)
            fileIn = "example.txt";
        else fileIn = args[0];
        List<String> readStrings = read(fileIn);
        LinkedList<String> ll = new LinkedList<>(readStrings);
        // write strings to file
        PrintWriter out = new PrintWriter(fileOut);
        int lineNumber = 1;
        for (String s : ll) {
            out.write(lineNumber++ + ": " + s + "\n");
        }
        out.close();
        // print output file
        System.out.println(BufferedInputFile.read(fileOut));
    }
}
