package chapters.eleven.containers.map.wordscount.deserialization;

import chapters.eleven.containers.stack.TextFile;

import java.util.*;
import java.util.stream.Collectors;

import static chapters.eleven.containers.map.wordscount.list.WordCountIntoFileTestDrive.getWordFrequency;

public class DeserializationByFile {
    public static void main(String[] args) {
        TextFile file = new TextFile("src/test/java/chapters/eleven/containers/map/wordscount/UniqueWordsAlphabetic.java", "\\W+");

        Map<String, ArrayList<Integer>> wordFrequency = getWordFrequency(file);
        printAsSource(wordFrequency);

    }

    private static void printAsSource(Map<String, ArrayList<Integer>> wordFrequency) {
        LinkedHashMap<Integer, String> wordPositions = new LinkedHashMap<>(wordFrequency.size());

        Set<String> allWords = wordFrequency.keySet();

        for (String word : allWords) {
            ArrayList<Integer> values = wordFrequency.get(word);
            for (Integer position : values) {
                    wordPositions.put(position, word);
            }
        }

        LinkedHashMap<Integer, String> collect = wordPositions.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        printValues(collect);
    }

    private static void printValues(LinkedHashMap<Integer, String> map) {
        for (String s : map.values()) {
            System.out.print(s + " ");
        }
    }
}
