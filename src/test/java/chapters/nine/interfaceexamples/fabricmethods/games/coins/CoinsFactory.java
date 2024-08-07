package chapters.nine.interfaceexamples.fabricmethods.games.coins;

public class CoinsFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Coins();
    }
}
