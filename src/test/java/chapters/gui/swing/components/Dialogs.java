package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialogs extends JFrame {
    private JButton b1 = new JButton("Dialog Box");
    private MyDialog myDialog = new MyDialog(null);

    public Dialogs() throws HeadlessException {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDialog.setVisible(true);
            }
        });
        add(b1);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Dialogs(), 125, 85);
    }

    private class MyDialog extends JDialog {
        public MyDialog(Frame parent) {
            super(parent, "Custom Dialog", true);
            setLayout(new FlowLayout());
            add(new JLabel("Here is my Dialog"));
            JButton ok = new JButton("OK");
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); // закрывает окно
                }
            });
            add(ok);
            setSize(350, 125);
        }
    }
}
