package chapters.nineteen.enums.vowelsandconsonants;

import java.util.Arrays;
import java.util.Random;

public enum EnumTask5 {

    VOWEL('a', 'e', 'i', 'o', 'u'),
    SOMETIMES_A_VOWEL('w', 'y'),
    CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
            'r', 's', 't', 'v', 'x', 'z'),
    ;
    private final Character[] letters;

    EnumTask5(java.lang.Character... letters) {
        this.letters = letters;
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            System.out.print((char) c + ", " + c + ": ");
            System.out.println(LetterType((char) c));
        }
    }

    private static EnumTask5 LetterType(char c) {
        if (Arrays.asList(VOWEL.letters).contains(c))
            return VOWEL;
        if (Arrays.asList(SOMETIMES_A_VOWEL.letters).contains(c))
            return SOMETIMES_A_VOWEL;
        return CONSONANT;
    }
}
