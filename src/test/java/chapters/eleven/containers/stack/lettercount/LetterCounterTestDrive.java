package chapters.eleven.containers.stack.lettercount;

import chapters.eleven.containers.stack.TextFile;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LetterCounterTestDrive {
    public static void main(String[] args) {
        String word;
        Set<String> wordsInFile = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        wordsInFile.addAll(new TextFile("src/test/java/chapters/eleven/containers/stack/StackTestDrive.java", "\\W+"));

        Iterator<String> iterator = wordsInFile.iterator();
        while (iterator.hasNext()) {
            word = iterator.next();
            System.out.printf("В слове %s количество гласных букв = %s%n", word, LetterCounter.getVowelsCount(word));
        }

    }
}
