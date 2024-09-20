package chapters.thirteen.strings.fileparsers;

import utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentParser {

    public static final String COMMENTS_REGEX = "\\/{2}\\s*(.)*";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: <fileName.extension>");
            System.exit(0);
        }
        // test comment
        String read = TextFile.read(args[0]);
        // test comment 2
        //test comment 2
        Pattern p = Pattern.compile(COMMENTS_REGEX, Pattern.COMMENTS | Pattern.MULTILINE);
        Matcher matcher = p.matcher(read);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

