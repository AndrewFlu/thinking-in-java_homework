package chapters.gui.tasks.task_11;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColoredButtonFrame extends JFrame {
    private RandomColoredButton randomColoredButton = new RandomColoredButton("Click to change background color");
    private Color color = new Color(0xFeFF);
    private Random rand = new Random();

    public ColoredButtonFrame() throws HeadlessException {
        add(BorderLayout.SOUTH, randomColoredButton);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ColoredButtonFrame(), 500, 300);
    }

    private class RandomColoredButton extends JButton {
        public RandomColoredButton(String label) {
            super(label);
            setBackground(color);
            setOpaque(true);
            setBorderPainted(false);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBackground(new Color(rand.nextInt(0xFFFFFF)));
                }
            });
        }
    }
}
