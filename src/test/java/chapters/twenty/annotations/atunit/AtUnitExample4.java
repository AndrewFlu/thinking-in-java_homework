package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

import java.util.*;

import static net.mindview.utils.Print.print;

public class AtUnitExample4 {

    static String theory = "All brontosauruses " +
            "are thin at one end, much MUCH thicker in the " +
            "middle, and then again at the far end.";

    private String word;
    private Random rand = new Random();

    public AtUnitExample4(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String scrambleWord() {
        List<Character> chars = new ArrayList<>();
        for (Character c : word.toCharArray())
            chars.add(c);
        Collections.shuffle(chars, rand);
        StringBuilder result = new StringBuilder();
        for (char ch : chars)
            result.append(ch);
        return result.toString();
    }

//    @TestProperty
    static List<String> input = Arrays.asList(theory.split(" "));
//   @TestProperty
    static Iterator<String> words = input.iterator();
//    @TestObjectCreate
    static AtUnitExample4 create() {
        if (words.hasNext())
            return new AtUnitExample4(words.next());
        else
            return null;
    }

    @Test
    boolean words() {
        print("'" + getWord() + "'");
        return getWord().equals("are");
    }

    @Test
    boolean scramble() {
        // Замена инициализацией конкретным значением
        // для получения воспроизводимых результатов
        rand = new Random(47);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        return scrambled.equals("lal");
    }

    @Test
    boolean scramble2() {
        rand = new Random(95);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        return scrambled.equals("tsaeborornussu");
    }

    public static void main(String[] args) {
        System.out.println("Starting");
        OSExecute.command("java chapters.twenty.annotations.atunit.AtUnitExample4");
    }
}
