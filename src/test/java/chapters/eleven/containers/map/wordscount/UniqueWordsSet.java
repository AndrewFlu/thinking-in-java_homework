package chapters.eleven.containers.map.wordscount;

import chapters.eleven.containers.stack.TextFile;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordsSet {
    public static void main(String[] args) {
        TextFile file = new TextFile("src/test/java/chapters/eleven/containers/map/wordscount/UniqueWordsAlphabetic.java", "\\W+");

        Set<WordContainer> setWords = new HashSet<>();
        for (String s : file) {
            setWords.add(new WordContainer(s));
        }

        System.out.println(setWords);

    }
}
