package chapters.twenty_one.concurrency.interrupt.check_interrupting_idiom;

import static net.mindview.utils.Print.print;

public class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int ident) {
        id = ident;
        print("NeedsCleanup " + id);
    }

    public void cleanup() {
        print("Cleaning up " + id);
    }
}
