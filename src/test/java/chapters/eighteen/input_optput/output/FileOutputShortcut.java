package chapters.eighteen.input_optput.output;

import chapters.eighteen.input_optput.input.BufferedInputFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    static String fileOut = "FileOutputShortcut.out";
    static String fileIn = "src/test/java/chapters/eighteen/input_optput/output/FileOutputShortcut.java";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read(fileIn))
        );
        // Сокращённая запись
        PrintWriter out = new PrintWriter(fileOut);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        // Вывод сохранённого файла:
        System.out.println(BufferedInputFile.read(fileOut));
    }
}
