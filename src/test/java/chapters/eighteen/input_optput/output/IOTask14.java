package chapters.eighteen.input_optput.output;

import chapters.eighteen.input_optput.input.BufferedInputFile;

import java.io.*;

public class IOTask14 {
    static String fileIn = "src/test/java/chapters/eighteen/input_optput/output/IOTask14.java";
    static String fileOut1 = "IOTask14Output1.out";
    static String fileOut2 = "IOTask14Output2.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read(fileIn)));
        // buffered writer
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(fileOut1)));
        int lineCount = 1;
        String s;
        long start = System.nanoTime();
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        long duration = System.nanoTime() - start;
        out.close();
        System.out.println("Buffered writing has completed in " + duration + " nanoseconds");

        BufferedReader in2 = new BufferedReader(new StringReader(BufferedInputFile.read(fileIn)));
        // non buffered writer
        PrintWriter out2 = new PrintWriter(new FileWriter(fileOut2));
        int lineCount2 = 1;
        String s2;
        long start2 = System.nanoTime();
        while ((s2 = in2.readLine()) != null)
            out2.println(lineCount2++ + ": " + s2);
        long duration2 = System.nanoTime() - start;
        out2.close();
        System.out.println("Unbuffered writing has completed in " + duration2 + " nanoseconds");

        // Вывод сохранённых файлов
        System.out.println(BufferedInputFile.read(fileOut1));
        System.out.println(BufferedInputFile.read(fileOut2));
    }
}
