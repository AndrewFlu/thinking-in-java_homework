package chapters.gui.tasks.task_5;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MotorcyclesGUI extends JFrame {
    private JTextField input = new JTextField("Motorcycles Company", 50);
    private JButton button1 = new JButton("Yamaha");
    private JButton button2 = new JButton("Harley-Davidson");
    private JButton button3 = new JButton("Honda");
    private ActionListener buttonListener = actionEvent -> {
        String buttonLabel = ((JButton) actionEvent.getSource()).getText();
        input.setText(buttonLabel);
    };

    public MotorcyclesGUI() throws HeadlessException {
        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);

        setLayout(new FlowLayout());
        add(input);
        add(button1);
        add(button2);
        add(button3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MotorcyclesGUI(), 700, 500);
    }
}
