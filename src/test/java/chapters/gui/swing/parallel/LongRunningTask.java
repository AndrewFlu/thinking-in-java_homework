package chapters.gui.swing.parallel;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * Плохо написанная программа: при нажатии на кнопку b1 поток диспетчерзации событий
 * становится занят продолжительным выполнением задачи.
 * И все другие действия будут недоступны: ни нажатие на кнопку b2, ни закрытие окна программы
 */
public class LongRunningTask extends JFrame {
    private JButton b1 = new JButton("Start Long Running Task");
    private JButton b2 = new JButton("End Long Running Task");

    public LongRunningTask() throws HeadlessException {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException ex) {
                    System.out.println("Task interrupted");
                    return;
                }
                System.out.println("Task completed");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread.currentThread().interrupt();
            }
        });

        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new LongRunningTask(), 350, 250);
    }
}
