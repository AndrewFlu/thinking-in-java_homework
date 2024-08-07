package chapters.nine.interfaceexamples.fabricmethods.games.coins;

public class Coins implements Game{
    private final static int MAX_TRIES = 5;
    private int tries = 0;
    @Override
    public boolean throwUp() {
        System.out.printf("Подбрасываем монетку %s-й раз%n", tries);

        return ++tries != MAX_TRIES;
    }
}
