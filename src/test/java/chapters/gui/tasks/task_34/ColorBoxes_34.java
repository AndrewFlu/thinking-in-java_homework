package chapters.gui.tasks.task_34;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ColorBoxes_34 extends JFrame {

    private int grid = 10;
    private int pause = 150;

    private ExecutorService executor = Executors.newCachedThreadPool();

    public ColorBoxes_34() throws HeadlessException {
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            ColoredArea coloredArea = new ColoredArea(pause);
            add(coloredArea);
            executor.execute(coloredArea);
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new ColorBoxes_34(), 550, 350);
    }

    private class ColoredArea extends JPanel implements Runnable {

        private Color color = new Color(0);
        private int pause;
        private Random random = new Random();

        public ColoredArea(int pause) {
            this.pause = pause;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // для очистки фона
            g.setColor(color);

            // Координаты центра звезды
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = Math.min(getHeight(), getWidth()) / 2; // радиус звезды

            // Рисуем звезду
            drawStar(g, centerX, centerY, radius);
        }

        private void drawStar(Graphics g, int centerX, int centerY, int radius) {
            int[] xPoints = new int[10];
            int[] yPoints = new int[10];

            // Вычисляем точки звезды
            for (int i = 0; i < 10; i++) {
                double angle = Math.PI / 2 + i * Math.PI / 5;
                int r = (i % 2 == 0) ? radius : radius / 2;
                xPoints[i] = (int) (centerX + r * Math.cos(angle));
                yPoints[i] = (int) (centerY - r * Math.sin(angle));
            }

            // Рисуем заполненную звезду
            g.fillPolygon(xPoints, yPoints, 10);
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    color = new Color(random.nextInt(0xFFFFFF));
                    repaint(); // асинхронный запрос paint()
                    TimeUnit.MILLISECONDS.sleep(pause);
                }
            } catch (InterruptedException e) {
                // допустимый способ выхода
            }
        }
    }
}
