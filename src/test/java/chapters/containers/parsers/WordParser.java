package chapters.containers.parsers;

import java.util.Collection;

public class WordParser {
    public static void main(String[] args) {
        Collection<String> allWords = new CustomCollectionInitialiser("src/main/resources/Pushkin.txt").getWordCollection();
        System.out.println(allWords);
    }
}
