package chapters.nine.interfaceexamples.fabricmethods.games.coins;

public class Cubs implements Game {
    private static final int MAX_TRIES = 10;
    private int tries = 0;
    @Override
    public boolean throwUp() {
        System.out.println(String.format("Бросаем кубики %s-й раз", tries + 1));

        return ++tries != MAX_TRIES;
    }
}
