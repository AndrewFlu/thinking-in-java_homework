package chapters.twenty_one.concurrency.piped_io;

import java.io.IOException;
import java.io.PipedReader;

public class Receiver implements Runnable {

    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getOut());
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Блокируется до появления символов
                System.out.println("Read: " + (char) in.read() + ", ");
            }
        } catch (IOException e) {
            System.out.println("Receiver read exception: " + e);
        }
    }
}
