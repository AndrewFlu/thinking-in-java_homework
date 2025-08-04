package chapters.gui.tasks.task_8;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class CustomCursor extends JFrame {

    public CustomCursor() throws HeadlessException {
        setLayout(new FlowLayout());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingConsole.run(new CustomCursor(), 700, 350);
    }
}
