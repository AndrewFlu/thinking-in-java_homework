package chapters.gui.swing.utils;

import javax.swing.*;

public class SwingConsole {
    public static void run(final JFrame f, final int width, final int height) { // todo: почему final?
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setVisible(true);
            }
        });
    }
}
