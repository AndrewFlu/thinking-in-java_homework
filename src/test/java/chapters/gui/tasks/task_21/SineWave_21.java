package chapters.gui.tasks.task_21;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

class SineDraw_21 extends JPanel {

    private static final int SCALE_FACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;
    public SineDraw_21() { setCycles(5); }

    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALE_FACTOR * cycles * 2;
        sines = new double[points];
        for(int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALE_FACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        repaint();
    }

    public int getCycles() {
        return cycles;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        double hstep = (double) maxWidth / (double) points;
        int maxHeight = getHeight();
        pts = new int[points];
        for (int i = 0; i < points; i++) {
            pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + (double) maxHeight / 2);
        }
        g.setColor(Color.RED);
        for (int i = 1; i < points; i++) {
            int x1 = (int) ((i - 1) * hstep);
            int x2 = (int) (i * hstep);
            int y1 = pts[i - 1];
            int y2 = pts[i];
            g.drawLine(x1, y1, x2, y2);
        }
    }
}

public class SineWave_21 extends JFrame {

    private SineDraw_21 sines  = new SineDraw_21();
    private JSlider adjustCycles = new JSlider(1, 30, 5);

    public SineWave_21() throws HeadlessException {
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
        SwingConsole.run(new SineWave_21(), 700, 400);
    }
}

