package chapters.gui.tasks.task_2;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelloLabel {

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("This is a label");

        frame.add(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);

        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < rand.nextInt(1, 5); i++) {
            TimeUnit.SECONDS.sleep(1);
            label.setText("New label #" + i);
        }
    }
}
