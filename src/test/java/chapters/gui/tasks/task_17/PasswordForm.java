package chapters.gui.tasks.task_17;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class PasswordForm extends JFrame {
    private String DEFAULT_PASSWORD = "Password";

    private JTextField login = new JTextField(25);
    private JPasswordField password = new JPasswordField(25);
    private JButton submit = new JButton("Sign In");


    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] passwordChars = password.getPassword();
            if (Arrays.equals(passwordChars, DEFAULT_PASSWORD.toCharArray())) {
                JOptionPane.showMessageDialog(null, "Пароль верный!", "Авторизация",
                        JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "Логин или Пароль некорректен", "Авторизация",
                        JOptionPane.ERROR_MESSAGE
                );
        }
    };

    public PasswordForm() throws HeadlessException {
        setLayout(new FlowLayout());
        submit.addActionListener(al);
        add(new JLabel("Login"));
        add(login);
        add(new JLabel("Password"));
        add(password);
        add(submit);
    }

    public static void main(String[] args) {
        SwingConsole.run(new PasswordForm(), 400, 250);
    }
}
