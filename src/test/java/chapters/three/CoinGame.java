package chapters.three;

import java.util.Random;

public class CoinGame {
    public static void main(String[] args) {
        System.out.println("Подбрасывается монетка! ...");
        Coin coin = new Coin();
        coin.toss();
        System.out.println("Выпал/-а: " + coin.side);
    }

    private static class Coin {
        String side;

        void toss() {
            Random random = new Random();
            int i = random.nextInt(10);
            if (i > 5) {
                side = "Решка";
            } else {
                side = "Орёл";
            }
        }
    }
}
