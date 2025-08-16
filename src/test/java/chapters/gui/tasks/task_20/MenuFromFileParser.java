package chapters.gui.tasks.task_20;

import chapters.gui.swing.utils.SwingConsole;
import net.mindview.utils.TextFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MenuFromFileParser extends JFrame {

    JLabel label = new JLabel("Enter file name for parse into menu:");
    JTextField textField = new JTextField(25);
    JButton button = new JButton("Parse file into menu");

    JMenuBar menuBar = new JMenuBar();
    JMenu upperCaseMenu = new JMenu("UppercaseMenu");
    JMenu lowerCaseMenu = new JMenu("LowerCaseMenu");
    JMenu otherMenu = new JMenu("OtherMenu");

    Set<String> words = new TreeSet<>();
    Set<String> lowerCaseSet = new TreeSet<>();
    Set<String> upperCaseSet = new TreeSet<>();
    Set<String> otherWordsSet = new TreeSet<>();

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear sets and menus from previously searched file
            words.clear();
            lowerCaseSet.clear();
            upperCaseSet.clear();
            otherWordsSet.clear();

            upperCaseMenu.removeAll();
            lowerCaseMenu.removeAll();
            otherMenu.removeAll();

            // parsing
            File file = new File(textField.getText());
            if (!file.isFile())
                textField.setText("Enter valid file name (e.g.: \"source.txt\")");
            else {
                words = new TreeSet<>(new TextFile(textField.getText(), "\\W+"));
                Iterator<String> iterator = words.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    if (Character.isLowerCase(word.charAt(0)))
                        lowerCaseSet.add(word);
                    else if (Character.isUpperCase(word.charAt(0)))
                        upperCaseSet.add(word);
                    else
                        otherWordsSet.add(word);
                }
                //  наполняем менюшки элементами
                for (String word : lowerCaseSet)
                    lowerCaseMenu.add(new JMenuItem(word));
                for (String word : upperCaseSet)
                    upperCaseMenu.add(new JMenuItem(word));
                for (String word : otherWordsSet)
                    otherMenu.add(new JMenuItem(word));
            }
        }
    };


    public MenuFromFileParser() throws HeadlessException {
        setLayout(new FlowLayout());
        // наполняем меню-бар
        menuBar.add(upperCaseMenu);
        menuBar.add(lowerCaseMenu);
        menuBar.add(otherMenu);
        // добавляем меню-бар на форму
        add(menuBar);

        label.setLabelFor(textField);
        add(label);
        add(textField);
        button.addActionListener(al);
        add(button);

        // Обновляем форму
        validate();
    }

    public static void main(String[] args) {
        SwingConsole.run(new MenuFromFileParser(), 350, 350);
    }
}
