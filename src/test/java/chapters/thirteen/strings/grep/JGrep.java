package chapters.thirteen.strings.grep;

import net.mindview.utils.TextFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
        Matcher m = p.matcher("");

        File file = new File(args[0]);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                processFile(f, m);
            }
        } else {
            processFile(file, m);
        }
    }

    private static void processFile(File file, Matcher matcher) {
        int index = 0;
        List<String> strings = new TextFile(file.getPath());
        for (String line : strings) {
            matcher.reset(line);
            while (matcher.find()) {
                System.out.println(index++ + ": " +
                        matcher.group() + ": " + matcher.start());
            }
        }
    }
}
