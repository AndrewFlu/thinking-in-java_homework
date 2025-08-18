package chapters.gui.tasks.task_25;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class SineDraw extends JPanel {

    private static final int SCALE_FACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    // добавим анимацию и управление ею с помощью слайдера
    private java.util.Timer timer = new Timer();
    private double offset;
    private JSlider adjustSpeed = new JSlider(5, 55, 45);

    public SineDraw() {
        super(new BorderLayout());
        add(BorderLayout.SOUTH, adjustSpeed);
        adjustSpeed.setInverted(true);
        adjustSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                timer.cancel();
                timer = new Timer();
                timer.scheduleAtFixedRate(new MyTimerTask(), 0, adjustSpeed.getValue());
            }
        });
        setCycles(5);
        timer.scheduleAtFixedRate(new MyTimerTask(), 300, 50);
    }

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

    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            offset += 0.15;
            synchronized (SineDraw.this) {
                for (int i = 0; i < points; i++) {
                    double radians = (Math.PI / SCALE_FACTOR) * i + offset;
                    sines[i] = Math.sin(radians);
                }
            }
            repaint();
        }
    }
}

public class SineWave_25 extends JFrame {

    private SineDraw sines  = new SineDraw();
    private JSlider adjustCycles = new JSlider(1, 30, 5);

    public SineWave_25() throws HeadlessException {
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
        SwingConsole.run(new SineWave_25(), 700, 400);
    }
}

