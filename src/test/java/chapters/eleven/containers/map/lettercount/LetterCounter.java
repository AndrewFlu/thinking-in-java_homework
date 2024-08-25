package chapters.eleven.containers.map.lettercount;

import chapters.eleven.containers.stack.TextFile;

import java.util.*;

public class LetterCounter {
    private static final Set<String> vowels = new HashSet<>(List.of("a e i o u y".split(" ")));

    public static int getVowelsCount(String word) {
        List<String> listOfVowels = new ArrayList<>(Arrays.asList(word.split("")));
        listOfVowels.retainAll(vowels);

        return listOfVowels.size();
    }

    public static Map<String, Integer> getVowelEntryStatistic(TextFile file) {
        Map<String, Integer> map = new HashMap<>();
        for (String key : vowels) {
            map.put(key, 0);
        }

        for (String word : file) {
            for (String key : word.split("")) {
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                }
            }
        }

        return map;
    }
}
