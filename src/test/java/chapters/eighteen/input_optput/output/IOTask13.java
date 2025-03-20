package chapters.eighteen.input_optput.output;

import chapters.eighteen.input_optput.input.BufferedInputFile;

import java.io.*;

public class IOTask13 {
    static String fileOut = "IOTask13Output.out";
    static String fileIn = "src/test/java/chapters/eighteen/input_optput/output/IOTask13.java";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read(fileIn)));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(fileOut)));
        String s;

        LineNumberReader lineReader = new LineNumberReader(new BufferedReader(new FileReader(fileIn)));
        while ((s = lineReader.readLine()) != null) {
            out.println(lineReader.getLineNumber() + ": " + s);
        }
        out.close();

        // Вывод сохранённого файла
        System.out.println(BufferedInputFile.read(fileOut));
    }
}
