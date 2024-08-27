package chapters.eleven.containers.map.wordscount.list;

import chapters.eleven.containers.stack.TextFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordCountIntoFileTestDrive {
    public static void main(String[] args) {
        TextFile file = new TextFile("src/test/java/chapters/eleven/containers/map/wordscount/UniqueWordsAlphabetic.java", "\\W+");
        Map<String, ArrayList<Integer>> wordFrequency = getWordFrequency(file);

        printFrequency(wordFrequency);
    }

    public static Map<String, ArrayList<Integer>> getWordFrequency(TextFile file) {
        Map<String, ArrayList<Integer>> wordFrequency = new HashMap<>();

        for (int i = 0; i < file.size(); i++) {
            String currentKey = file.get(i);
            if (wordFrequency.containsKey(currentKey)) {
                ArrayList<Integer> currentList = wordFrequency.get(currentKey);
                currentList.add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                wordFrequency.put(currentKey, list);
            }
        }
        return wordFrequency;
    }

    private static void printFrequency(Map<String, ArrayList<Integer>> wordFrequency) {
        for (String key : wordFrequency.keySet()) {
            ArrayList<Integer> value = wordFrequency.get(key);
            System.out.println(String.format("Слово [%s] встречается в файле %s раз(-а)", key, value.size()));
            System.out.println(String.format("    в позициях: %s", value));
        }
    }
}
