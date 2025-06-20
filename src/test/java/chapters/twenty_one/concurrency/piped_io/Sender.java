package chapters.twenty_one.concurrency.piped_io;

import chapters.sixteen.arrays.multydimensionalarrays.ThreeDWithNew;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            }
        } catch (IOException e) {
            System.out.println("Sender write exception: " + e);
        } catch (InterruptedException e) {
            System.out.println("Sender sleep interrupted: " + e);
        }
    }
}
