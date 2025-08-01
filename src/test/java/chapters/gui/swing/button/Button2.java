package chapters.gui.swing.button;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Реакция на нажатия кнопки
public class Button2 extends JFrame{
    private JButton
            b1 = new JButton("Кнопка 1"),
            b2 = new JButton("Кнопка 2");
    private JTextField txt = new JTextField(10);
    private ButtonListener bl = new ButtonListener();

    public Button2() {
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = ((JButton) e.getSource()).getText();
            txt.setText(text);
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2(), 200, 150);
    }
}
