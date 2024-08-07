package chapters.nine.interfaceexamples.fabricmethods.games.coins;

public class CubsFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Cubs();
    }
}
