package chapters.gui.swing.base;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SubmitSwingProgram extends JFrame {
    JLabel label;

    public SubmitSwingProgram() throws HeadlessException {
        super("Hello Swing");
        label = new JLabel("A Label");
        add(label);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
    }

    static SubmitSwingProgram ssp;

    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp = new SubmitSwingProgram();
            }
        });
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label.setText("Hey! This is THE LABEL!");
            }
        });
    }

}
