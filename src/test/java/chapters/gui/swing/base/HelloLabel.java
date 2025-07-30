package chapters.gui.swing.base;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HelloLabel {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("This is a label");

        frame.add(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);

        TimeUnit.SECONDS.sleep(2);
        label.setText("Hey! This is a new label's text :)");
    }
}
