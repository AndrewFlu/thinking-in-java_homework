package chapters.gui.tasks.task_29;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserTest extends JFrame {
    private static final Color DEFAULT_COLOR = Color.green;
    private JButton button = new JButton("Open ColorChooserDialog");
    JPanel managingPanel = new JPanel();
    JPanel resultPanel = new JPanel();

    public ColorChooserTest() throws HeadlessException {
        JPanel managingPanel = new JPanel();
        button.addActionListener(new BL());
        managingPanel.add(button);
        add(managingPanel, BorderLayout.NORTH);

        resultPanel.setBackground(DEFAULT_COLOR);
        add(resultPanel, BorderLayout.CENTER);
    }

    private class BL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JColorChooser colorChooser = new JColorChooser(Color.CYAN);
            Color chosenColor = JColorChooser.showDialog(null, "Выберите цвет", DEFAULT_COLOR);
            if (chosenColor != null)
                resultPanel.setBackground(chosenColor);
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new ColorChooserTest(), 350, 350);
    }
}
