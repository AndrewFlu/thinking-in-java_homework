package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HTMLButton extends JFrame {
    private JButton b = new JButton(
            "<html><b><font size=+2>" +
                    "<center>Hello!<br><i>Press me now!"
    );

    public HTMLButton() {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new JLabel("<html>" +
                        "<i><font size=+4>Hi!"
                ));
                // Инициировать пересчёт расположения
                // для включения новой надписи
                // (т.к. компонент накладывается на форму ПОСЛЕ конструирования?
                // макет формы необходимо построить заново)
                validate();
            }
        });
        setLayout(new FlowLayout());
        add(b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new HTMLButton(), 450, 150);
    }
}
