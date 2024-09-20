package chapters.thirteen.strings.grep;

import utils.TextFile;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    private static Map<String, Integer> flagsMap = new HashMap<>();
    static {
        flagsMap.put("MULTILINE", Pattern.MULTILINE);
        flagsMap.put("CASE_INSENSITIVE", Pattern.CASE_INSENSITIVE);
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: <filename.extension> <regular expression>, Pattern.<flag>");
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1], flagsMap.get(args[2]));
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
