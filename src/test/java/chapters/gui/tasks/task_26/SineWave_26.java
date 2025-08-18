package chapters.gui.tasks.task_26;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SineWave_26 extends JFrame {

    private SineDraw[] sines;
    private JSlider cycles = new JSlider(1, 30, 5);

    public SineWave_26(int numOfPanels) {
        int side = Math.round((float) Math.sqrt((double) numOfPanels));
        JPanel jp = new JPanel(new GridLayout(side, side));
        sines = new SineDraw[numOfPanels];
        for (int i = 0; i < sines.length; i++) {
            sines[i] = new SineDraw();
            jp.add(sines[i]);
        }


        add(jp);
        cycles.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                for (int i = 0; i < sines.length; i++) {
                    sines[i].setCycles(((JSlider) e.getSource()).getValue());

                }
            }
        });
        add(BorderLayout.SOUTH, cycles);
    }

    public static void main(String[] args) {
        int numOfPanels = 6;
        if (args.length > 0 )
            numOfPanels = Integer.parseInt(args[0]);
        SwingConsole.run(new SineWave_26(numOfPanels), 700, 400);
    }
}

