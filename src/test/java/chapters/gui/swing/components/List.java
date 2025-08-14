package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
    };
    private DefaultListModel defaultListModel = new DefaultListModel();
    private JList list = new JList(defaultListModel);
    private JTextArea textArea = new JTextArea(flavors.length, 30);
    private JButton button = new JButton("Add Item");
    private int count = 0;

    private ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (count < flavors.length)
                defaultListModel.add(0, flavors[count++]);
            else
                // Отключить, в список List добавлены все необходимые элементы
                button.setEnabled(false);
        }
    };
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

    public List() throws HeadlessException {
        textArea.setEditable(false);
        setLayout(new FlowLayout());
        // Создание рамки для компонентов
        Border border = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.GREEN);
        textArea.setBorder(border);

        // Добавляем в список первые 4 элемента
        for (int i = 0; i < 4; i++) {
            defaultListModel.addElement(flavors[count++]);
        }
        add(textArea);
        add(list);
        add(button);

        // Регистрация слушателя событий
        list.addListSelectionListener(listSelectionListener);
        button.addActionListener(buttonListener);
    }

    public static void main(String[] args) {
        SwingConsole.run(new List(), 450, 375);
    }
}
