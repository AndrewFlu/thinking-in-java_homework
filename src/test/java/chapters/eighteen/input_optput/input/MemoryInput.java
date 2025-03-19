package chapters.eighteen.input_optput.input;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("src/test/java/chapters/eighteen/input_optput/input/MemoryInput.java")
        );
        int c;
        while ((c = in.read()) != -1) {
            System.out.println((char)c);
        }
    }
}
