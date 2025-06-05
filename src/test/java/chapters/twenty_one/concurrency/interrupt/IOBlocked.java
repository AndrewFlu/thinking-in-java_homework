package chapters.twenty_one.concurrency.interrupt;

import java.io.IOException;
import java.io.InputStream;

import static net.mindview.utils.Print.print;

public class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream is) {
        this.in = is;
    }

    @Override
    public void run() {
        try {
            print("Waiting for read");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                print("Interrupted from blocked I/O");
            } else throw new RuntimeException(e);
        }
        print("Exiting IOBlocked.run()");
    }
}
