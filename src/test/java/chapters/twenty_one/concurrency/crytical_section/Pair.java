package chapters.twenty_one.concurrency.crytical_section;

public class Pair { // Потоково-небезопасный класс
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairNotEqualException extends RuntimeException {
        public PairNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }
    // Произвольный инвариант — переменные должны быть равны
    public void checkState() {
        if (x != y) {
            throw new PairNotEqualException();
        }
    }
}

