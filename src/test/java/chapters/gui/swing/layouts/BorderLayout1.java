package chapters.gui.swing.layouts;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class BorderLayout1 extends JFrame {

    public BorderLayout1() throws HeadlessException {
        add(BorderLayout.NORTH, new JButton("Север"));
        add(BorderLayout.SOUTH, new JButton("Юг"));
        add(BorderLayout.WEST, new JButton("Запад"));
        add(BorderLayout.EAST, new JButton("Восток"));
        add(BorderLayout.CENTER, new JButton("Центр"));
    }

    public static void main(String[] args) {
        SwingConsole.run(new BorderLayout1(), 300, 250);
    }

}
