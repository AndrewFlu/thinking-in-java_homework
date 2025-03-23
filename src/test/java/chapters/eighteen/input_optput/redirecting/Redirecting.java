package chapters.eighteen.input_optput.redirecting;

import java.io.*;

public class Redirecting {

    static final String file = "src/test/java/chapters/eighteen/input_optput/redirecting/Redirecting.java";

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out; // back up standard out

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        System.setIn(in);

        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null)
            System.out.println(s);
        out.close(); // не забывать!

        System.setOut(console); // restore standard out from back-up
    }
}
