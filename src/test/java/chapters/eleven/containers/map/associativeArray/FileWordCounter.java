package chapters.eleven.containers.map.associativeArray;

import utils.TextFile;

public class FileWordCounter {
    public static void main(String[] args) {
        String file = TextFile.read("src/main/resources/Pushkin.txt");
        String[] words = file.replaceAll("\\.", "").split("\\s");
        AssociativeArray<String, Integer> wordCounter = new AssociativeArray<>(words.length);

        for (String str : words) {
            Integer count = wordCounter.get(str);
            wordCounter.put(str, count == null ? 1 : count + 1);
        }
        System.out.println(wordCounter);
    }
}
