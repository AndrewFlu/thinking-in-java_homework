package chapters.eleven.containers.map.wordscount;

import chapters.eleven.containers.stack.TextFile;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueWordsAlphabetic {
    public static void main(String[] args) {
        TextFile file = new TextFile("src/test/java/chapters/eleven/containers/map/wordscount/UniqueWordsAlphabetic.java", "\\W+");
        file.sort(String.CASE_INSENSITIVE_ORDER);

        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        // initiate map with keys
        for (String key : file) {
            wordsMap.put(key, 0);
        }

        // find entry count for every word
        for (String word : file) {
            if (wordsMap.containsKey(word)) {
                wordsMap.replace(word, wordsMap.get(word) + 1);
            }
        }
        // print resulted map
        System.out.println(wordsMap);
    }
}
