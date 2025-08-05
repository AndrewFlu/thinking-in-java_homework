package chapters.gui.swing.layouts;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class GridLayout1 extends JFrame {

    public GridLayout1() throws HeadlessException {
        setLayout(new GridLayout(7, 3)); // 21 ячейка
        for (int i = 0; i < 20; i++) {
            add(new JButton("Button " + i)); // но под 20 компонентов (1 ячейка остаётся свободной)
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new GridLayout1(), 500, 500);
    }
}
