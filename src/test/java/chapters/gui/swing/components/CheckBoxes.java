package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxes extends JFrame {

    private JTextArea textArea = new JTextArea(6, 15);
    private JCheckBox
            checkBox1 = new JCheckBox("Check Box 1"),
            checkBox2 = new JCheckBox("Check Box 2"),
            checkBox3 = new JCheckBox("Check Box 3");


    public CheckBoxes() throws HeadlessException {
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trace("1", checkBox1);
            }
        });
        checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trace("2", checkBox2);
            }
        });
        checkBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trace("3", checkBox3);
            }
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
    }

    private void trace(String boxName, JCheckBox checkBox) {
        if (checkBox.isSelected())
            textArea.append("Box " + boxName + " Set\n");
        else
            textArea.append("Box " + boxName + " Cleared\n");
    }

    public static void main(String[] args) {
        SwingConsole.run(new CheckBoxes(), 200, 300);
    }
}
