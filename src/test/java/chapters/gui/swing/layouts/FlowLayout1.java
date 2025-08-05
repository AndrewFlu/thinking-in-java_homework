package chapters.gui.swing.layouts;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class FlowLayout1 extends JFrame {
    public FlowLayout1() throws HeadlessException {
        setLayout(new FlowLayout());
        for (int i = 0; i < 20; i++) {
            add(new JButton("Button " + i));
        };
    }

    public static void main(String[] args) {
        SwingConsole.run(new FlowLayout1(), 300, 500);
    }
}
