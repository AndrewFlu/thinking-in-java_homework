package chapters.thirteen.strings.fileparsers;

import utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiteralParser {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: fileName.extension");
            System.exit(1);
        }
        String fileString = TextFile.read(args[0]);
        Pattern p = Pattern.compile("\"\\b(\\w)+(.)*\\b\"");
        Matcher m = p.matcher(fileString);
        while(m.find()) {
            System.out.println(m.group());
        }
    }
}
