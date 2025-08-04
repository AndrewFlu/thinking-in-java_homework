package chapters.gui.tasks.task_7;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingComponents extends JFrame {
    private JTextArea textArea = new JTextArea(20, 15);

    private JTextField input = new JTextField("Input", 15);
    private JButton button = new JButton("Button");
    private String[] strings = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split("\\s") ;
    private JComboBox<String> select = new JComboBox<>(strings);
    private JMenuItem menuItem = new JMenuItem("MenuItem");
    private JFileChooser fileChooser = new JFileChooser(".");

    public SwingComponents() throws HeadlessException {
        setLayout(new FlowLayout());

        // textArea
        add(new JScrollPane(textArea));

        // input
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Input" + "\n");
            }
        });
        add(input);

        // button
        button.addActionListener(event -> textArea.append("Button" + "\n"));
        add(button);

        // select
        select.addActionListener(event -> textArea.append("Select" + "\n"));
        add(select);

        // menuItem
        menuItem.addActionListener(event -> textArea.append("MenuItem" + "\n"));
        add(menuItem);

        // fileChooser
        fileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("FileChooser" + "\n");
            }
        });
        add(fileChooser);

        new Timer(3_000, new ActionListener() {
            private int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Timer " + i++ + "\n");
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingConsole.run(new SwingComponents(), 700, 800);
    }
}
