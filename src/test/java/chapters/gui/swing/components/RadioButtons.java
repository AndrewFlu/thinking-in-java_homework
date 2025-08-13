package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtons extends JFrame {
    private JTextField textField = new JTextField(30);
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton
            radioButton1 = new JRadioButton("one", false),
            radioButton2 = new JRadioButton("two", false),
            radioButton3 = new JRadioButton("three", false);
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText("Radio Button " + ((JRadioButton) e.getSource()).getText());
        }
    };

    public RadioButtons() throws HeadlessException {
        // adjust components
        radioButton1.addActionListener(actionListener);
        radioButton2.addActionListener(actionListener);
        radioButton3.addActionListener(actionListener);
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        textField.setEditable(false);

        // construct form
        setLayout(new FlowLayout());
        add(textField);
        add(radioButton1);
        add(radioButton2);
        add(radioButton3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new RadioButtons(), 410, 450);
    }
}
