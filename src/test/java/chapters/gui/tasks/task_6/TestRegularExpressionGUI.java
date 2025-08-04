package chapters.gui.tasks.task_6;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpressionGUI extends JFrame {
    private JPanel panel = new JPanel();

    private JTextArea sourceTextArea = new JTextArea(15, 30);
    private JTextArea resultTextArea = new JTextArea(15, 30);
    private JTextField regexInput = new JTextField(50);
    private JButton button = new JButton("Проверить");
    private JLabel
            sourceTextAreaLabel = new JLabel("Текст"),
            resultTextAreaLabel = new JLabel("Результат совпадения"),
            regexLabel = new JLabel("Регулярное выражение");

    public TestRegularExpressionGUI() throws HeadlessException {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTextArea.setText("");
                String[] args = sourceTextArea.getText().split("\n");
                String regexp = regexInput.getText();
                checkRegex(regexp, args);
            }
        });
        // Позиционирование элементов с помощью GridLayout
        GridLayout gridLayout = new GridLayout(4, 2);

        panel.setLayout(gridLayout);

        // source textArea
        sourceTextAreaLabel.setLabelFor(sourceTextArea);
        panel.add(sourceTextAreaLabel);
        panel.add(new JScrollPane(sourceTextArea));

        // regex input
        regexLabel.setLabelFor(regexInput);
        panel.add(regexLabel);
        panel.add(regexInput);

        // result textArea
        resultTextAreaLabel.setLabelFor(resultTextArea);
        panel.add(resultTextAreaLabel);
        panel.add(new JScrollPane(resultTextArea));

        // test button
        panel.add(button);

        add(panel);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run(new TestRegularExpressionGUI(), 700, 500);
        TimeUnit.SECONDS.sleep(30);
        System.exit(1);
    }

    private static void validateArgs(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression " +
                    "characterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\"");
    }

    private void checkRegex(String regexp, String[] args) {
        for (String s : args) {
            resultTextArea.append("Regular expression:" + regexp + "\n");
            Pattern p = Pattern.compile(regexp);
            Matcher m = p.matcher(s);
            while (m.find()) {
                resultTextArea.append("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1) + "\n");
            }
        }
    }

}
