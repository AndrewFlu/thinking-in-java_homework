package chapters.eighteen.input_optput.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    // Вывод исключений на консоль
    public static String read(String fileName) throws IOException {
        // Чтение по строкам
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb
                    .append(s)
                    .append("\n")
            ;
        }
        in.close();

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String fileName = "src/test/java/chapters/eighteen/input_optput/input/BufferedInputFile.java";
        System.out.println(read(fileName));
    }
}
