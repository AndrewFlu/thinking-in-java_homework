package chapters.gui.swing.textarea;

import chapters.containers.countries.Countries;
import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TextArea extends JFrame {
    private JButton
            addButton = new JButton("Add Data"),
            clearButton = new JButton("Clear Data");
    private JTextArea textArea = new JTextArea(20, 40);
    private Map<String, String> map = new HashMap<>();

    public TextArea() throws HeadlessException {
        // Использовать все данные:
        map.putAll(Countries.countries());
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry entry : map.entrySet())
                    textArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(addButton);
        add(clearButton);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextArea(), 475, 425);
    }
}
