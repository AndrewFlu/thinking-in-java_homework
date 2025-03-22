package chapters.eighteen.input_optput.statndard;

import java.io.*;

public class IOTask21 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/test/java/chapters/eighteen/input_optput/statndard/IOTask21.java");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        System.setIn(inputStream);

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while ((s = stdin.readLine()) != null)
                System.out.println(s.toUpperCase());
        } finally {
            stdin.close();
        }
    }
}
