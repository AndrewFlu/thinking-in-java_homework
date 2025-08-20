package chapters.gui.swing.parallel;

import chapters.gui.swing.utils.SwingConsole;
import net.mindview.utils.TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

public class InterruptableLongRunningCallable extends JFrame {

    private JButton b1 = new JButton("Start Long Running Task");
    private JButton b2 = new JButton("End Long Running Task");
    private JButton b3 = new JButton("Get results");

    private TaskManager<String, CallableTask> manager = new TaskManager<String, CallableTask>();

    public InterruptableLongRunningCallable() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CallableTask task = new CallableTask();
                manager.add(task);
                System.out.println(task + " added to the queue");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String result : manager.purge()) {
                    System.out.println(result);
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Пример вызова метода Task:
                for (TaskManager.TaskItem<String, CallableTask> tt : manager) {
                    tt.task.id();// Преобразование типа не требуется
                }
                for (String result : manager.getResults())
                    System.out.println(result);
            }
        });

        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new InterruptableLongRunningCallable(), 350, 150);
    }
}

class CallableTask extends Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        run();
        return "Return value of " + this;
    }
}
