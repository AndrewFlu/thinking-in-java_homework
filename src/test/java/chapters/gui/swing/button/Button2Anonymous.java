package chapters.gui.swing.button;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button2Anonymous extends JFrame {

    public static final String DELAYED_LABEL = "В избранное";
    public static final String BASKET_LABEL = "В корзину";
    private JButton
            button1 = new JButton(BASKET_LABEL),
            button2 = new JButton(DELAYED_LABEL);
    private JTextField input = new JTextField(30); // todo: что такое 10?

    //    private BtnListener btnListener = new BtnListener();
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btnName = ((JButton) e.getSource()).getText();
            if (btnName.equals(BASKET_LABEL))
                input.setText("Добавлено в корзину");
            if (btnName.equals(DELAYED_LABEL))
                input.setText("Добавлено в избранное");
        }
    };

    public Button2Anonymous() throws HeadlessException {
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        setLayout(new FlowLayout());
        add(button1);
        add(button2);
        add(input);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2Anonymous(), 500, 300);
    }

//    private class BtnListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String btnName = ((JButton)e.getSource()).getText();
//            if (btnName.equals(BASKET_LABEL))
//                input.setText("Добавлено в корзину");
//            if (btnName.equals(DELAYED_LABEL))
//                input.setText("Добавлено в избранное");
//        }
//    }
}
