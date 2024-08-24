package chapters.eleven.containers.stack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {

    public TextFile(String path, String regex) {
        super(Arrays.asList(read(path).split(regex)));

        if (get(0).isEmpty()) remove(0);
    }

    private static String read(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path).getAbsoluteFile()))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s);
                sb.append("\n");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
