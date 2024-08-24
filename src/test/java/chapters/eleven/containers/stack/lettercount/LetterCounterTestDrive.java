package chapters.eleven.containers.stack.lettercount;

import chapters.eleven.containers.stack.TextFile;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LetterCounterTestDrive {
    public static void main(String[] args) {
        String word;
        Set<String> wordsInFile = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        TextFile file = new TextFile("src/test/java/chapters/eleven/containers/stack/StackTestDrive.java", "\\W+");
        wordsInFile.addAll(file);

        Iterator<String> iterator = wordsInFile.iterator();
        while (iterator.hasNext()) {
            word = iterator.next();
            System.out.printf("В слове %s количество гласных букв = %s%n", word, LetterCounter.getVowelsCount(word));
        }

        System.out.println();
        int allVowelsCount = getSumOfVowels(file);
        System.out.println("Общее количество гласных в файле = " + allVowelsCount);

    }

    private static int getSumOfVowels(TextFile file) {
        int sum = 0;
        for (String s : file) {
            sum += LetterCounter.getVowelsCount(s);
        }

        return sum;
    }
}
