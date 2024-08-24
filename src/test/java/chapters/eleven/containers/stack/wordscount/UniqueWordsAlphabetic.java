package chapters.eleven.containers.stack.wordscount;

import chapters.eleven.containers.stack.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWordsAlphabetic {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(new TextFile("src/test/java/chapters/eleven/containers/stack/StackTestDrive.java", "\\W+"));

        System.out.println(words);
    }
}
