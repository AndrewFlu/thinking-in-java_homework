package chapters.five;

public class FinalizeExample {
    boolean isReadyToNextGuest;

    public FinalizeExample(boolean isReadyToNextGuest) {
        this.isReadyToNextGuest = isReadyToNextGuest;
    }

    public void closeRent() {
        if (isReadyToNextGuest) {
            finalize();
        }
    }

    @Override
    public void finalize() {
            System.out.println("метод finalize() вызван");
            isReadyToNextGuest = false;
    }

    public static void main(String[] args) {
        FinalizeExample ready = new FinalizeExample(true);
        FinalizeExample notReady = new FinalizeExample(false);

        ready.closeRent();
        notReady.closeRent();
    }

    public boolean isReadyToNextGuest() {
        return isReadyToNextGuest;
    }
}
