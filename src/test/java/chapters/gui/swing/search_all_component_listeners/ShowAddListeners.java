package chapters.gui.swing.search_all_component_listeners;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Вывод списка доступных методов "addXXXListener"
 * для любого класса библиотеки Swing
 */
public class ShowAddListeners extends JFrame {
    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40,65);

    private static Pattern addListenerPattern = Pattern.compile("(add\\w+?Listener\\(.*?\\))");
    private static Pattern qualifier = Pattern.compile("\\w+\\.");

    class NameL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nm = name.getText().trim();
            if (nm.length() == 0) {
                results.setText("No match");
                return;
            }
            Class<?> kind;
            try {
                kind = Class.forName("javax.swing." + nm);
            } catch (ClassNotFoundException ex) {
                results.setText("No match");
                return;
            }
            Method[] methods = kind.getMethods();
            results.setText("");
            for (Method m : methods) {
                Matcher matcher = addListenerPattern.matcher(m.toString());
                if (matcher.find())
                    // убирает данные пакета у аргумента:
                    // (addInputMethodListener(java.awt.event.InputMethodListener) -> addInputMethodListener(InputMethodListener))
                    results.append(qualifier.matcher(matcher.group(1)).replaceAll("") + "\n");
            }
        }
    } // end of class NameL

    public ShowAddListeners() {
        NameL nameListener = new NameL();
        name.addActionListener(nameListener);

        JPanel top = new JPanel();
        top.add(new JLabel("Swing class name (press Enter):"));
        top.add(name);
        add(BorderLayout.NORTH, top);
        add(new JScrollPane(results));
        // исходные данные и проверка:
        name.setText("JTextArea");
        nameListener.actionPerformed(new ActionEvent("", 0, "")); // todo: эмулирует нажатие (action)?
    }

    public static void main(String[] args) {
        SwingConsole.run(new ShowAddListeners(), 600, 500);
    }
}
