package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Использование отражения для создания групп кнопок,
 * производных от базовой кнопки AbstractButton
 */
public class ButtonGroups extends JFrame {

    private static String[] ids = {
            "Купить", "Продать", "В избранное", "В корзину", "Сравнить", "Уведомить о поступлении"
    };

    static JPanel makeBPanel(Class<? extends AbstractButton> buttonKind, String[] ids) {
        ButtonGroup bg = new ButtonGroup();
        JPanel jp = new JPanel();
        String title = buttonKind.getName();

        jp.setBorder(new TitledBorder(title));
        for (String id : ids) {
            AbstractButton ab = new JButton("failed");
            try {
                // получение динамического конструктора
                // с аргументом типа String
                Constructor ctor = buttonKind.getConstructor(String.class);
                // Создание нового объекта
                ab = (AbstractButton) ctor.newInstance(id);
            } catch (Exception e) {
                System.err.println("Can't create " + buttonKind);
            }
            bg.add(ab);
            jp.add(ab);
        }
        return jp;
    }

    public ButtonGroups() throws HeadlessException {
        setLayout(new FlowLayout());
        add(makeBPanel(JButton.class, ids));
        add(makeBPanel(JToggleButton.class, ids));
        add(makeBPanel(JCheckBox.class, ids));
        add(makeBPanel(JRadioButton.class, ids));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonGroups(), 850, 500);
    }
}
