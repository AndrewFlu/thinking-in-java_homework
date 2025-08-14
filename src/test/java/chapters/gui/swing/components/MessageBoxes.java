package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Демонстрация возможностей JOptionPane
 */
public class MessageBoxes extends JFrame {
    private JButton[] buttonArray = {
            new JButton("Alert"), new JButton("Yes/No"),
            new JButton("Color"), new JButton("Input"),
            new JButton("3 Vals")
    };
    private JTextField input = new JTextField(15);
    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonName = ((JButton) e.getSource()).getText();
            if (buttonName.equals("Alert"))
                JOptionPane.showMessageDialog(null, "Обнаружен дефект", "Так!", JOptionPane.ERROR_MESSAGE);
            else if (buttonName.equals("Yes/No"))
                JOptionPane.showConfirmDialog(null, "или 'Нет'", "Выберите 'Да'", JOptionPane.YES_NO_OPTION);
            else if (buttonName.equals("Color")) {
                Object[] options = {"Red", "Green"};
                int select = JOptionPane.showOptionDialog(
                        null, "Choose a Color!", "Warning",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null,
                        options, options[0]
                );
                if (select != JOptionPane.CLOSED_OPTION)
                    input.setText("color Selected: " + options[select]);
            } else if (buttonName.equals("Input")) {
                String value = JOptionPane.showInputDialog("How many fingers do you see?");
                input.setText(value);
            } else if (buttonName.equals("3 Vals")) {
                Object[] selections = {"First", "Second", "Third"};
                Object val = JOptionPane.showInputDialog(
                        null, "Choose One", "Input",
                        JOptionPane.INFORMATION_MESSAGE,
                        null, selections, selections[0]
                );
                if (val != null)
                    input.setText(val.toString());
            }
        }
    };

    public MessageBoxes() throws HeadlessException {
        setLayout(new FlowLayout());
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].addActionListener(al);
            add(buttonArray[i]);
        }
        add(input);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MessageBoxes(), 250, 250);
    }
}
