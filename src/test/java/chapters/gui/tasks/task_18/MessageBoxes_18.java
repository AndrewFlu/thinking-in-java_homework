package chapters.gui.tasks.task_18;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * Демонстрация возможностей JOptionPane
 */
public class MessageBoxes_18 extends JFrame {
    private JButton
            alertButton = new JButton("Внимание"),
            yesNoButton = new JButton("Да/Нет"),
            colorButton = new JButton("Цвет"),
            inputButton = new JButton("Текстовый ввод"),
            threeValuesButton = new JButton("3 значения на выбор");
    private JTextField input = new JTextField(15);

    public MessageBoxes_18() throws HeadlessException {
        setLayout(new FlowLayout());
        alertButton.addActionListener(__ -> JOptionPane.showMessageDialog(
                null,
                "У тебя всё получится!",
                "Внимание!",
                JOptionPane.INFORMATION_MESSAGE
        ));
        yesNoButton.addActionListener(__ -> JOptionPane.showConfirmDialog(
                null,
                "Выберите 'Да' или 'Нет'",
                "Сделайте выбор",
                JOptionPane.YES_NO_OPTION
        ));
        colorButton.addActionListener(__ -> {
            Object[] options = {"Red", "Green"};
            int select = JOptionPane.showOptionDialog(
                    null, "Выберите цвет", "Внимание",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null,
                    options, options[0]);
            if (select != JOptionPane.CLOSED_OPTION)
                input.setText("Выбранный цвет: " + options[select]);
        });
        inputButton.addActionListener(__ -> {
            String value = JOptionPane.showInputDialog("How many fingers do you see?");
            input.setText(value);
        });
        threeValuesButton.addActionListener(__ -> {
            Object[] selections = {"First", "Second", "Third"};
            Object val = JOptionPane.showInputDialog(
                    null, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE,
                    null, selections, selections[0]
            );
            if (val != null)
                input.setText(val.toString());
        });
        add(alertButton);
        add(yesNoButton);
        add(colorButton);
        add(inputButton);
        add(threeValuesButton);
        add(input);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MessageBoxes_18(), 250, 250);
    }
}
