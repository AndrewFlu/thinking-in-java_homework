package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Демонстрация панели вкладок
 */
public class TabPaneFrame extends JFrame {

    private String actions[] = {
            "Отложить", "Заказать", "Купить",
            "Сравнить", "Характеристики", "Отзывы",
            "Поделиться", "Скопировать ссылку"
    };
    private JTabbedPane tabs = new JTabbedPane();
    private JTextField txt = new JTextField(20);

    public TabPaneFrame() throws HeadlessException {
        int i = 0;
        for (String action : actions) {
            tabs.addTab(actions[i], new JButton("Область вкладки с индексом " + i++));
        }
        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                txt.setText("Выбрана вкладка с индексом: " + tabs.getSelectedIndex());
            }
        });

        add(BorderLayout.SOUTH, txt);
        add(tabs);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TabPaneFrame(), 500, 350);
    }
}
