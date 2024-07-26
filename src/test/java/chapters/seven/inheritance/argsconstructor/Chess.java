package chapters.seven.inheritance.argsconstructor;

class Game {
    Game(int i) {
        System.out.println("Конструктор Game");
    }
}

class BoardGame extends Game {

    BoardGame(int i ) {
        super(i);
        System.out.println("Конструктор BoardGame");
    }
}

public class Chess extends BoardGame {
    Chess(int i) {
        super(i);
        System.out.println("Конструктор Chess");
    }

    public static void main(String[] args) {
        Game chess = new Chess(5);
    }
}
