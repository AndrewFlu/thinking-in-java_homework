package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleMenus extends JFrame {

    private JTextField textField = new JTextField(15);
    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText(((JMenuItem) e.getSource()).getText());
        }
    };
    private JMenu[] menus = {
            new JMenu("File"), new JMenu("Edit"),
            new JMenu("View"), new JMenu("Navigate"),
    };
    private JMenuItem[] items = {
            new JMenuItem("Open"), new JMenuItem("Close file"), new JMenuItem("Save as"),
            new JMenuItem("Copy"), new JMenuItem("Paste"), new JMenuItem("Delete"),
            new JMenuItem("Recent changes"), new JMenuItem("Zoom"), new JMenuItem("Increase"),
            new JMenuItem("Previous"), new JMenuItem("Next"), new JMenuItem("Jump to"),
    };

    public SimpleMenus() throws HeadlessException {
        for (int i = 0; i < items.length; i++) {
            items[i].addActionListener(al);
            menus[i % 4].add(items[i]);
        }
        JMenuBar menuBar = new JMenuBar();
        for (JMenu jm : menus)
            menuBar.add(jm);
        setJMenuBar(menuBar);
        add(textField);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SimpleMenus(), 500, 350);
    }
}
