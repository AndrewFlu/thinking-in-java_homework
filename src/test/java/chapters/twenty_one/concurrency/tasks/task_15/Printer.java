package chapters.twenty_one.concurrency.tasks.task_15;

public class Printer {
    private final int maxInkCapacity = 1000;
    public int actualInkQauntity;

    public Printer(int actualInkState) {
        if (actualInkState <= maxInkCapacity)
            this.actualInkQauntity = actualInkState;
        if (actualInkState > maxInkCapacity)
            this.actualInkQauntity = maxInkCapacity;
    }

    public boolean canPrint() {
        if (actualInkQauntity > 0)
            return true;
        throw new UnsufficientInkException();
    }

    private class UnsufficientInkException extends RuntimeException {
        public UnsufficientInkException() {
            super("Недостаточно чернил для печати");
        }
    }
}
