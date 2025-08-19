package chapters.gui.tasks.task_31;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Asymptote extends JFrame {

    private Random rand = new Random(47);
    private JProgressBar progressBar = new JProgressBar();
    private int delay = 100;
    private javax.swing.Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int nextInt = rand.nextInt(6);
            if (nextInt == 0)
                progressBar.setValue(progressBar.getValue() + rand.nextInt(100));
            else
                delay *= 1.2;
            timer.setDelay(delay);
            progressBar.setValue(progressBar.getValue() + 3);
        }
    });


    public Asymptote() throws HeadlessException {
        progressBar.setValue((int) (progressBar.getMaximum() * 0.05));
        timer.start();

        add(progressBar);

    }

    public static void main(String[] args) {
        SwingConsole.run(new Asymptote(), 550, 350);
    }
}
