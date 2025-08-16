package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Создание всплывающих меню библиотеки Swing
 */
public class Popup extends JFrame {

    private final JPopupMenu popup = new JPopupMenu();
    private final JTextField textField = new JTextField(15);

    public Popup() throws HeadlessException {
        setLayout(new FlowLayout());
        add(textField);
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(((JMenuItem) e.getSource()).getText());
            }
        };
        JMenuItem menuItem = new JMenuItem("Hither"); // hither — здесь
        menuItem.addActionListener(al);
        popup.add(menuItem);

        menuItem = new JMenuItem("Yon"); // yon — там
        menuItem.addActionListener(al);
        popup.add(menuItem);

        menuItem = new JMenuItem("Afar"); // afar — вдалеке
        menuItem.addActionListener(al);
        popup.add(menuItem);

        popup.addSeparator();

        menuItem = new JMenuItem("Stay Here");
        menuItem.addActionListener(al);
        popup.add(menuItem);

        PopupListener pl = new PopupListener();
        addMouseListener(pl);
        textField.addMouseListener(pl);
    }

    class PopupListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger())
                popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new Popup(), 300, 250);
    }
}
