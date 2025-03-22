package chapters.eighteen.input_optput.textfile;

import net.mindview.utils.TextFile;

import java.util.Map;
import java.util.TreeMap;

public class IOTask17 {
    public static void main(String[] args) {
        String pomXml = TextFile.read("pom.xml");
        Map<Character, Integer> counter = new TreeMap<>();
        for (char c : pomXml.toCharArray())
            counter.put(c, counter.containsKey(c) ? counter.get(c) + 1 : 1);

        System.out.println(counter);
    }
}
