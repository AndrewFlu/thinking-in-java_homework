package chapters.gui.tasks.task_27;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SineWave_27 extends JFrame {

    private SineDraw sines  = new SineDraw();
    private JSlider adjustCycles = new JSlider(1, 30, 5);

    public SineWave_27() throws HeadlessException {
        add(sines);
        adjustCycles.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sines.setCycles(((JSlider)e.getSource()).getValue());
            }
        });
        add(BorderLayout.SOUTH, adjustCycles);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SineWave_27(), 700, 400);
    }
}

