package chapters.nine.interfaceexamples.fabricmethods.games.coins;

public class GamesTestDrive {
    public static void main(String[] args) {
        playGame(new CoinsFactory());
        System.out.println("");
        playGame(new CubsFactory());
    }

    private static void playGame(GameFactory gameFactory) {
        Game game = gameFactory.getGame();
        while (game.throwUp()) {
            continue;
        }
    }
}
