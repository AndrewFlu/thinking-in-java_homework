package chapters.gui.swing.parallel;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ColorBoxes extends JFrame {

    private static ExecutorService executor = Executors.newCachedThreadPool(); // todo: почему static?

    private int grid = 12;
    private int pause = 50;

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    public ColorBoxes() throws HeadlessException {
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            CBox cbox = new CBox(pause);
            add(cbox);
            executor.execute(cbox);
        }
    }

    public static void main(String[] args) {
        ColorBoxes boxes = new ColorBoxes();
        if (args.length > 0)
            boxes.setGrid(Integer.parseInt(args[0]));
        if (args.length > 1)
            boxes.setPause(Integer.parseInt(args[1]));

        SwingConsole.run(boxes, 500, 400);
    }

    private class CBox extends JPanel implements Runnable {

        private int pause;
        private static Random rand = new Random();
        private Color color = new Color(0);

        public CBox(int pause) {
            this.pause = pause;
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(color);
            Dimension size = getSize();
            g.fillRect(0, 0, size.width, size.height);
        }

        @Override
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    color = new Color(rand.nextInt(0xFFFFFF));
                    repaint(); // асинхронный запрос paint()
                    TimeUnit.MILLISECONDS.sleep(pause);
                }
            } catch (InterruptedException e) {
                // Допустимый способ выхода
            }
        }
    }
}
