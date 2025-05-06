package chapters.twenty_one.concurrency.responsive_ui;

import java.io.IOException;

public class UnresponsiveUI {
    private static volatile double d = 1;

    public UnresponsiveUI() throws IOException {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
            System.in.read(); // never gets here
        }
    }

    public static void main(String[] args) throws IOException {
        new UnresponsiveUI();
        System.out.println(d); // вывод информации о ходе выполнения
    }
}
