package chapters.gui.tasks.task_10;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ButtonFocusLogger extends JFrame {
    private JTextField input = new JTextField(50);
    private JButton button = new JButton("Установите фокус");

    public ButtonFocusLogger() throws HeadlessException {
        input.setEditable(false);
        input.setBackground(Color.LIGHT_GRAY);
        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                input.setText(String.valueOf(e.getKeyChar()));
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        add(BorderLayout.NORTH, input);
        add(BorderLayout.SOUTH, button);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonFocusLogger(), 500, 300);
    }

}
