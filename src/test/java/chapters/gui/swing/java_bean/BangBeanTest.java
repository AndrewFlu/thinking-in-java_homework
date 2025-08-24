package chapters.gui.swing.java_bean;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;

/**
 * {Timeout: 5} Отмена через 5 секунд
 */
public class BangBeanTest extends JFrame {

    private JTextField txt = new JTextField(20);

    public BangBeanTest() throws HeadlessException {
        BangBean bb = new BangBean();
        try {
            bb.addActionListener(new BBL());
        } catch (TooManyListenersException e) {
            txt.setText("Too many listeners");
        }
        add(bb);
        add(BorderLayout.SOUTH, txt);
    }

    // Во время тестирования сообщать о действиях:
    class BBL implements ActionListener {
        private int count = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            txt.setText("BangBean action (class BBL) " + count++);
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new BangBeanTest(), 550, 350);
    }
}
