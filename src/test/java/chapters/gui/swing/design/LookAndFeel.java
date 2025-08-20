package chapters.gui.swing.design;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class LookAndFeel extends JFrame {

    private String choices[] = {
            "X3 F25 Rest 25i",
            "X3 F25 Rest 30d",
            "X3 F25 3.0d",
            "X5 F15 30i",
            "X5 F15 25d",
    };
    private Component[] samples = {
            new JButton("JButton"),
            new JTextField("JTextField"),
            new JLabel("JLabel"),
            new JCheckBox("JCheckBox"),
            new JRadioButton("JRadioButton"),
            new JComboBox<>(choices), // селект
            new JList<>(choices),
    };

    public LookAndFeel() throws HeadlessException {
        super("Look And Feel");
        setLayout(new FlowLayout());
        for (Component component : samples)
            add(component);
    }

    private static void usageError() {
        System.out.println("Usage:LookAndFeel [cross|system|motif]");
    }

    public static void main(String[] args) {
        // необходимо выполнить код установки внешнего вида программы ПЕРЕД созданием компонентов
        if (args.length == 0)
            usageError();
        if (args[0].equals("cross")) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args[0].equals("system")) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args[0].equals("motif")) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // После установки внешнего вида компонентов, можно запускать и саму программу (конструирование элементов)
        SwingConsole.run(new LookAndFeel(), 900, 350);
    }
}
