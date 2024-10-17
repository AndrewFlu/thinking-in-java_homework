package chapters.fifteen.generics.strorycharacters.marvel.infinitywar;

public class InfinityWarCharacters {
    public static void main(String[] args) {
        System.out.println(new IronMan());
        System.out.println(new Thanos());

        System.out.println("generate random characters...");

        System.out.println("print via for()...");
        CharacterGenerator gen = new CharacterGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        int characterCount = 10;
        System.out.println("print via foreach()...");
        CharacterGenerator foreachCharGen = new CharacterGenerator(characterCount);
        for (Character character : foreachCharGen) {
            System.out.println(character);
        }
    }
}
