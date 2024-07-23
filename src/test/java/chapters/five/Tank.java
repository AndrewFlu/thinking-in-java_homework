package chapters.five;

public class Tank {
    boolean isEmpty;

    public void fill() {
        isEmpty = false;
        System.out.println("Сосуд наполнен!");
    }

    public void empty() {
        isEmpty = true;
        System.out.println("Сосуд опустошён");
    }

    public void finalize() {
        if (!isEmpty) {
            System.out.println("Сначала опустошите сосуд");
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.fill();
        tank.finalize();
    }
}
