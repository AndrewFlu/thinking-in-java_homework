package chapters.gui.tasks.task_30;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class HTMLComponents extends JFrame {
    // menu
    private JMenu file = new JMenu("File");
    private JMenu view = new JMenu("View");
    private JMenuBar menuBar = new JMenuBar();

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JCheckBox checkBox1 = new JCheckBox("Чекбокс #1");
    private JCheckBox checkBox2 = new JCheckBox("Чекбокс #2");
    private ButtonGroup radioButtonGroup = new ButtonGroup();
    private JRadioButton radioButton1 = new JRadioButton("Переключатель #1");
    private JRadioButton radioButton2 = new JRadioButton("Переключатель #2");
    private JButton okButton = new JButton("<html><font size=+5>OK");

    public HTMLComponents() throws HeadlessException {
        // construct menu
        menuBar.add(file);
        menuBar.add(view);
        file.add(new JMenuItem("<html><b><i>Save as..."));
        file.add(new JMenuItem("<html><p style='color:green'>Open"));
        view.add(new JMenuItem("<html>На весь экран <span class=\"emoji\"> &#x1F5A5"));
        setJMenuBar(menuBar);

        // add tabbed pane
        JPanel checkBoxPanel = new JPanel();
        checkBox1.setToolTipText("<html><i>Написать программу");
        checkBox2.setToolTipText("<html><b>Протестировать программу");

        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(checkBox2);
        tabbedPane.addTab("Чекбоксы", checkBoxPanel);

        JPanel radioButtonPanel = new JPanel();
        radioButton1.setToolTipText("<html><b><p style='color:red'>Написать быстро");
        radioButton2.setToolTipText("<html><b><p style='color:green'>Написать хорошо");
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);

        radioButtonPanel.add(radioButton1);
        radioButtonPanel.add(radioButton2);
        tabbedPane.addTab("Переключатели", radioButtonPanel);
        add(tabbedPane);
        add(okButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingConsole.run(new HTMLComponents(), 550, 450);
    }
}
