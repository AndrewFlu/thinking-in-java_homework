package chapters.gui.tasks.task_15;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MotorcyclesGUI_15 extends JFrame {
    private JTextField input = new JTextField("Motorcycles Company", 33);
    private JButton button1 = new JButton("Yamaha");
    private JButton button2 = new JButton("Harley-Davidson");
    private JButton button3 = new JButton("Honda");

    private ActionListener buttonListener = actionEvent -> {
        String buttonLabel = ((JButton) actionEvent.getSource()).getText();
        input.setText(buttonLabel);
    };
    private JCheckBox checkBox = new JCheckBox("С выбранным брендом знаком");

    public MotorcyclesGUI_15() throws HeadlessException {
        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);

        setLayout(new FlowLayout());
        add(input);
        add(button1);
        add(button2);
        add(button3);

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected())
                    input.setText("C брендом знаком");
                else
                    input.setText("Бренд незнакомый");
            }
        });
        add(checkBox);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MotorcyclesGUI_15(), 500, 500);
    }
}
