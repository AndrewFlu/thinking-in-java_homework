package chapters.gui.swing.parallel;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Выполнение продлжительных задач в потоках
 */
public class InterruptableLongRunningTask extends JFrame {

    private JButton b1 = new JButton("Start Long Running Task");
    private JButton b2 = new JButton("End Long Running Task");

    // используется однопоточный объект экзекьютора,
    // который ставит ожидающие задачи в очередь
    // и выполняет их одну за другой
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public InterruptableLongRunningTask() throws HeadlessException {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task();
                exec.execute(task);
                System.out.println(task + " added to the queue");

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exec.shutdownNow(); // Силовое решение
                exec = Executors.newSingleThreadExecutor();
            }
        });
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new InterruptableLongRunningTask(), 550, 250);
    }

}
