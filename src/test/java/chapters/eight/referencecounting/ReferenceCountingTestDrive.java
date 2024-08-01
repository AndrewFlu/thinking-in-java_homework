package chapters.eight.referencecounting;

public class ReferenceCountingTestDrive {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
        };

        for (Composing c : composings) {
            c.dispose();
        }
        System.gc();
        System.runFinalization();

        new Composing(new Shared());
        System.gc();
        System.runFinalization();
    }
}