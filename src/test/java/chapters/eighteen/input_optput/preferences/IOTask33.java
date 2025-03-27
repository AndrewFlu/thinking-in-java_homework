package chapters.eighteen.input_optput.preferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

public class IOTask33 {
    public static void main(String[] args) throws IOException {
        Preferences preferences = Preferences.userNodeForPackage(IOTask33.class);
        String defaultProjectDirectory = new File(".").getCanonicalPath();
        String baseDirectory = preferences.get("base directory", defaultProjectDirectory);
        System.out.println("Base directory value: " + baseDirectory +
                "\nEnter new base directory value (String): ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            baseDirectory = br.readLine();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        preferences.put("base directory", baseDirectory);
    }
}
