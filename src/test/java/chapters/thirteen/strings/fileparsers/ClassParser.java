package chapters.thirteen.strings.fileparsers;

import net.mindview.utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassParser {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: <fileName.extension>");
            System.exit(0);
        }

        Pattern p = Pattern.compile("(\\b[A-Z][A-z]+(?)\\b);$", Pattern.MULTILINE);
        Matcher m = p.matcher(TextFile.read(args[0]));
        System.out.println("В классе " + ClassParser.class.getSimpleName() + " используются следующие классы:");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
