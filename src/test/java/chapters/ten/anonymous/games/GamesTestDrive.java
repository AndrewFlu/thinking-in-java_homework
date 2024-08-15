package chapters.ten.anonymous.games;

public class GamesTestDrive {
    public static void main(String[] args) {
        playGame(new GameFactory() {
            @Override
            public Game getGame() {
                return new Game() {
                    private final static int MAX_TRIES = 5;
                    private int tries = 0;

                    @Override
                    public boolean throwUp() {
                        System.out.printf("Подбрасываем монетку %s-й раз%n", tries + 1);

                        return ++tries != MAX_TRIES;
                    }
                };
            }
        });

        System.out.println("");

        playGame(new GameFactory() {
            @Override
            public Game getGame() {
                return new Game() {
                    private static final int MAX_TRIES = 10;
                    private int tries = 0;

                    @Override
                    public boolean throwUp() {
                        System.out.println(String.format("Бросаем кубики %s-й раз", tries + 1));

                        return ++tries != MAX_TRIES;
                    }
                };
            }
        });
    }

    private static void playGame(GameFactory gameFactory) {
        Game game = gameFactory.getGame();
        while (game.throwUp()) {
            continue;
        }
    }
}
