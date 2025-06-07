package chapters.twenty_one.concurrency.interrupt.check_interrupting_idiom;

import java.util.concurrent.TimeUnit;

import static net.mindview.utils.Print.print;

// Общая идиома прерывания задачи
// {args: 1100}
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1){
            print("Usage: java InterruptingIdiom <delay-in-ms>");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(Integer.parseInt(args[0]));
        t.interrupt();
    }
}
