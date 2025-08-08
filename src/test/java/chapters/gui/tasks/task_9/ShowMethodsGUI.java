package chapters.gui.tasks.task_9;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethodsGUI extends JFrame {

    private JTextField input = new JTextField(25);
    private JTextArea textArea = new JTextArea(4, 25);

    private static Pattern pattern = Pattern.compile("\\w+\\.");


    public ShowMethodsGUI() throws HeadlessException {
        InputListener inputListener = new InputListener();
        input.addActionListener(inputListener);

        JPanel top = new JPanel();
        top.add(new JLabel("Class name (press Enter)"));
        top.add(input);
        add(BorderLayout.NORTH, top);
        add(new JScrollPane(textArea));
        // Initial data and test:
        input.setText("java.lang.Integer");
        inputListener.actionPerformed(new ActionEvent("", 0, ""));
    }

    private class InputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
            String[] split = input.getText().trim().split("\\s");
            if (split.length == 0) {
                textArea.setText("No match");
            }
            Class<?> kind;
            try {
                kind = Class.forName(split[0]);
                Method[] methods = kind.getMethods();
                Constructor<?>[] constructors = kind.getConstructors();
                if (split.length == 1) {
                    for (Method method : methods)
                        textArea.append(pattern.matcher(method.toString()).replaceAll("") + "\n");
                    for (Constructor<?> constructor : constructors)
                        textArea.append(pattern.matcher(constructor.toString()).replaceAll("") + "\n");
                } else {
                    for (Method method : methods)
                        if (method.toString().indexOf(split[1]) != -1)
                            textArea.append(pattern.matcher(method.toString()).replaceAll("") + "\n");
                    for (Constructor<?> constructor : constructors)
                        if (constructor.toString().indexOf(split[1]) != -1)
                            textArea.append(pattern.matcher(constructor.toString()).replaceAll("") + "\n");
                }
            } catch (ClassNotFoundException ex) {
                textArea.append("No match");
            }
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new ShowMethodsGUI(), 500, 700);
    }

}
