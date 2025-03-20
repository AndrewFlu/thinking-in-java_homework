package chapters.eighteen.input_optput.input;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {

    public static final String FILE_PATH = "src/test/java/chapters/eighteen/input_optput/input/FormattedMemoryInput.java";

    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(BufferedInputFile.read(FILE_PATH).getBytes())
            );
            while (true)
                System.out.print((char)in.readByte());

        } catch (IOException e) {
            System.err.println("End of stream");
        }
    }
}
