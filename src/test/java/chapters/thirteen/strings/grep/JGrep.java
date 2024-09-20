package chapters.thirteen.strings.grep;

import utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: <filename.extension> <regular expression>");
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1]);
        // перебор строк входного файла
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find()) {
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
            }
        }
    }
}
