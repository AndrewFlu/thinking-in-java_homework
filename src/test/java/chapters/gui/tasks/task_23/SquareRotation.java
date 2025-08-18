package chapters.gui.tasks.task_23;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SquareRotation extends JFrame {

    private SquareDraw squareDraw = new SquareDraw();

    private JSlider speedSlider = new JSlider(1, 30, 5);
    private JSlider sizeSlider = new JSlider(1, 30, 10);

    public SquareRotation() throws HeadlessException {
        setLayout(new FlowLayout());
        add(squareDraw);
        speedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                squareDraw.setCycles(((JSlider)e.getSource()).getValue());
            }
        });
        add(speedSlider);
        add(sizeSlider);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SquareRotation(), 550 ,550);
    }

    private class SquareDraw extends JPanel {

        private static final int SCALE_FACTOR = 250;
        private int cycles;
        private int points;
        private double[] squares;
        private int[] pts;
        public SquareDraw() { setCycles(5); }

        public void setCycles(int newCycles) {
            cycles = newCycles;
            points = SCALE_FACTOR * cycles * 2;
            squares = new double[points];
            for(int i = 0; i < points; i++) {
//                double radians = (Math.PI / SCALE_FACTOR) * i;
                squares[i] = Math.pow(i, i);
            }
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int maxWidth = getWidth();
            double hstep = (double) maxWidth / (double) points;
            int maxHeight = getHeight();
            pts = new int[points];
            for (int i = 0; i < points; i++) {
//                pts[i] = (int) (squares[i] * maxHeight / 2 * .95 + (double) maxHeight / 2);
                pts[i] = (int) (squares[i] * maxHeight);
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
}
