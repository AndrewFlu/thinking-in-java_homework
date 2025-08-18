package chapters.gui.tasks.task_27;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SineDraw extends JPanel {

    private static final int SCALE_FACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    // добавим анимацию и управление ею с помощью слайдера
    private ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            offset += 0.15;
            for (int i = 0; i < points; i++) {
                double radians = (Math.PI / SCALE_FACTOR) * i + offset;
                sines[i] = Math.sin(radians);
            }
            repaint();
        }
    };

    private javax.swing.Timer timer = new javax.swing.Timer(10, taskPerformer);
    private double offset;

    private JSlider adjustSpeed = new JSlider(5, 50, 10);

    public SineDraw() {
        super(new BorderLayout());
        add(BorderLayout.SOUTH, adjustSpeed);
        adjustSpeed.setInverted(true);
        adjustSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                timer.setDelay(adjustSpeed.getValue());
            }
        });
        setCycles(5);
        timer.start();
    }

    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALE_FACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
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
}
