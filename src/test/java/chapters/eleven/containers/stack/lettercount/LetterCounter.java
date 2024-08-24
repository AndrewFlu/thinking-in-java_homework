package chapters.eleven.containers.stack.lettercount;

import java.util.*;

public class LetterCounter {
    private static final Set<String> vowels = new HashSet<>(List.of("a e i o u y".split(" ")));

    public static int getVowelsCount(String word) {
        List<String> listOfVowels = new ArrayList<>(Arrays.asList(word.split("")));
        listOfVowels.retainAll(vowels);

        return listOfVowels.size();
    }
}
