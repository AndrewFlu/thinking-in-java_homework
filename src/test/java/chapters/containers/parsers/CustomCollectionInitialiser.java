package chapters.containers.parsers;

import net.mindview.utils.TextFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CustomCollectionInitialiser  {
    private Collection<String> wordCollection;

    public CustomCollectionInitialiser(String filePath) {
        String file = TextFile.read(filePath);
        String[] split = file.split("\\s");
        String[] sanitized = sanitize(split);
        wordCollection = new ArrayList<>(Arrays.asList(sanitized));
    }

    private String[] sanitize(String[] split) {
        String[] result = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            String replace = split[i].replace(".", "");
            result[i] = replace;
        }
        return result;
    }

    public Collection<String> getWordCollection() {
        return wordCollection;
    }
}
