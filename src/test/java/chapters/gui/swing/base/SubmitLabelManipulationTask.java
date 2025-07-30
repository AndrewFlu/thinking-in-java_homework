package chapters.gui.swing.base;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SubmitLabelManipulationTask {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("I am a Label");

        frame.add(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1500,1000);
        frame.setVisible(true);

        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText("Hey! I am the Label!");
            }
        });
    }
}
