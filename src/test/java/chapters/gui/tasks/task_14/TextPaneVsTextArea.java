package chapters.gui.tasks.task_14;

import chapters.gui.swing.utils.SwingConsole;
import chapters.sixteen.arrays.generators.RandomGenerator;
import net.mindview.utils.Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JTextPane — миниатюрный редактор текста
 */
public class TextPaneVsTextArea extends JFrame {

    private JButton button = new JButton("Add Text");
//    private JTextPane textPane = new JTextPane();
    private JTextArea textArea = new JTextArea();
    private static Generator stringGenerator = new RandomGenerator.String(7);

    public TextPaneVsTextArea() throws HeadlessException {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
//                    textPane.setText(textPane.getText() + stringGenerator.next() + "\n");
                    textArea.setText(textArea.getText() + stringGenerator.next() + "\n");
                }
            }
        });
        add(new JScrollPane(textArea));
        add(BorderLayout.SOUTH, button);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextPaneVsTextArea(), 475, 425);
    }
}
