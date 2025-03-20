package chapters.eighteen.input_optput.output;

import chapters.eighteen.input_optput.input.BufferedInputFile;

import java.io.*;

public class BasicFileOutput {
    static String fileOut = "BasicFileOutput.out";
    static String fileIn = "src/test/java/chapters/eighteen/input_optput/output/BasicFileOutput.java";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read(fileIn)));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(fileOut)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();

        // Вывод сохранённого файла
        System.out.println(BufferedInputFile.read(fileOut));
    }
}
