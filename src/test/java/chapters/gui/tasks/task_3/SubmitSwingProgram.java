package chapters.gui.tasks.task_3;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SubmitSwingProgram extends JFrame {
    static SubmitSwingProgram ssp;
    JLabel label;

    public SubmitSwingProgram() throws HeadlessException {
        label = new JLabel("A Label");
        add(label);
    }


    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp = new SubmitSwingProgram();
                SwingConsole.run(ssp, 1_000, 500);
            }
        });
        TimeUnit.MILLISECONDS.sleep(1_500);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label.setText("Hey! This is THE LABEL!");
            }
        });
    }

}
