package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserTest extends JFrame {
    private JTextField
            fileName = new JTextField(),
            dir = new JTextField();
    private JButton
            open = new JButton("Open"),
            save = new JButton("Save");

    public FileChooserTest() {
        JPanel panel = new JPanel();
        open.addActionListener(new OpenL());
        panel.add(open);
        save.addActionListener(new SaveL());
        panel.add(save);
        add(panel, BorderLayout.SOUTH);
        dir.setEditable(false);
        fileName.setEditable(false);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(fileName);
        panel.add(dir);
        add(panel, BorderLayout.NORTH);
    }

    private class OpenL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            // Демонстрация открытия диалогового окна открытия файлов:
            int rVal = fileChooser.showOpenDialog(FileChooserTest.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fileName.setText(fileChooser.getSelectedFile().getName());
                dir.setText(fileChooser.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }

    private class SaveL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            // Демонстрация открытия диалогового окна сохранения файлов:
            int rVal = fileChooser.showSaveDialog(FileChooserTest.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fileName.setText(fileChooser.getSelectedFile().getName());
                dir.setText(fileChooser.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new FileChooserTest(), 500, 500);
    }
}
