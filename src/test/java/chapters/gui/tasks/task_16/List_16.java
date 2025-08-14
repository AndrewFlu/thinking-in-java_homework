package chapters.gui.tasks.task_16;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class List_16 extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
    };
    private JList list = new JList(flavors);
    private JTextArea textArea = new JTextArea(flavors.length, 30);

    private ListSelectionListener listSelectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting())
                return;
            textArea.setText("");
            for (Object item : list.getSelectedValues())
                textArea.append(item + "\n");
        }
    };

    public List_16() throws HeadlessException {
        textArea.setEditable(false);
        setLayout(new FlowLayout());
        // Создание рамки для компонентов
        Border border = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.GREEN);
        textArea.setBorder(border);

        add(textArea);
        add(list);

        // Регистрация слушателя событий
        list.addListSelectionListener(listSelectionListener);
    }

    public static void main(String[] args) {
        SwingConsole.run(new List_16(), 450, 375);
    }
}
