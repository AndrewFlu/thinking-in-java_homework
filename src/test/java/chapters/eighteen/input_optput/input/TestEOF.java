package chapters.eighteen.input_optput.input;

import java.io.*;

public class TestEOF {
    private static final String FILE_PATH = "src/test/java/chapters/eighteen/input_optput/input/TestEOF.java";

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(FILE_PATH)));
        while (in.available() != 0)
            System.out.print((char)in.readByte());
    }
}
