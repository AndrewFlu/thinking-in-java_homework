package chapters.twenty_one.concurrency.daemons.anchestors_is_daemons;

import java.util.concurrent.TimeUnit;

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        System.out.print("d.isDaemon() = " + d.isDaemon() + ", ");
        d.start();
        // Дать потокам-демонам завершить их стартовые процессы
        TimeUnit.SECONDS.sleep(1);
    }
}
