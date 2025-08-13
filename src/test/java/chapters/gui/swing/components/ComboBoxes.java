package chapters.gui.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Использование раскрывающихся списков
 */
public class ComboBoxes extends JFrame {
    private String[] purchaseList = {
            "Телевизор", "Блютус-колонка", "Кабель HDMI",
            "Шторы", "Журнальный столик", "Светильник напольный",
            "Покупка 1", "Покупка 2"
    };
    private JTextField input = new JTextField(20);
    private JComboBox comboBox = new JComboBox();
    private JButton button = new JButton("Добавить ещё один в список (если доступно)");
    private int index = 0;

    public ComboBoxes() throws HeadlessException {
        for (int i = 0; i < 4; i++) {
            comboBox.addItem(purchaseList[index++]);
        }
        input.setEditable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < purchaseList.length)
                    comboBox.addItem(purchaseList[index++]);
            }
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText("index: " + comboBox.getSelectedIndex() + " " +
                        ((JComboBox) e.getSource()).getSelectedItem());
            }
        });
        // construct  form
        setLayout(new FlowLayout());
        add(input);
        add(comboBox);
        add(button);
    }

    public static void main(String[] args) {
        ComboBoxes form = new ComboBoxes();
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setSize(350, 450);
        form.setVisible(true);
    }
}
