package chapters.thirteen.strings.replacement;

/*! Here's a block of text to use as input to
        the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block !*/

import utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("src/test/java/chapters/thirteen/strings/replacement/TheReplacements.java");
        // Поиск блока текста, заключенного в спецальные комментарии:
        Matcher mInput =
                Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
                        .matcher(s);

        if (mInput.find()) s = mInput.group(1); // Совпадение выражения в круглых скобках

        // два и более пробела заменяются одним пробелом
        s = s.replaceAll(" {2,}", " ");

        // один и более пробелов в начале строки заменяются пустой строкой
        // для выполнения должен быть активен режим MULTILINE
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);

        s = s.replaceFirst("[aeiou]", "(VOWEL1)");

        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);

        // обработка информации find при выполнении замены
        while (m.find()) m.appendReplacement(sbuf, m.group().toUpperCase());

        // присоединение оставшегося текста
        m.appendTail(sbuf);

        System.out.println(sbuf);
    }

}
