package chapters.gui.tasks.task_42;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import chapters.twenty_one.concurrency.daemons.DaemonThreadPoolExecutor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class StarsBoxes implements SWTApplication {

    private int grid = 12;
    private int pause = 50;


    @Override
    public void createContents(Composite parent) {
        GridLayout gridLayout = new GridLayout(grid, true);
        gridLayout.horizontalSpacing = 0;
        gridLayout.verticalSpacing = 0;
        parent.setLayout(gridLayout);

        ExecutorService executor = new DaemonThreadPoolExecutor();
        for (int i = 0; i < (grid * grid); i++) {
            final CBox cb = new CBox(parent, pause);
            cb.setLayoutData(new GridData(GridData.FILL_BOTH));
            executor.execute(cb);
        }
    }

    public static void main(String[] args) {
        StarsBoxes starsBoxes = new StarsBoxes();
        SWTConsole.run(starsBoxes, 550, 450);
    }
}

class CBox extends Canvas implements Runnable {

    private static Random random = new Random();

    private RGB cColor = newColor();

    Color color;
    private int pause;

    public CBox(Composite parent, int pause) {
        super(parent, SWT.NONE);
        this.pause = pause;
        addPaintListener(new CboxPaintListener());
    }

    private static RGB newColor() {
        return new RGB(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                cColor = newColor();
                getDisplay().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            redraw();
                        } catch (SWTException e) {
                            // Допустимый способ выхода
                        }
                    }
                });

                TimeUnit.MILLISECONDS.sleep(pause);
            }
        } catch (InterruptedException | SWTException e) {
            // Допустимый способ выхода
        }
    }

    private class CboxPaintListener implements PaintListener {
        @Override
        public void paintControl(PaintEvent paintEvent) {
            GC gc = paintEvent.gc;
            gc.setAntialias(SWT.ON); // Включаем сглаживание

            color = new Color(paintEvent.display, cColor);

            gc.setForeground(color);

            // Координаты центра звезды
            int centerX = getSize().x / 2;
            int centerY = getSize().y / 2;
            int radius = Math.min(getSize().y, getSize().x) / 2; // радиус звезды

            // Рисуем звезду
            drawStar(gc, centerX, centerY, radius);
        }
    }

    private void drawStar(GC gc, int centerX, int centerY, int radius) {
        int numPoints = 5; // Количество лучей звезды
        int innerRadius = radius / 2; // Радиус внутренних точек

        int[] points = new int[numPoints * 4]; // x,y для каждой точки

        for (int i = 0; i < numPoints; i++) {
            double outerAngle = 2 * Math.PI * i / numPoints - Math.PI / 2;
            double innerAngle = 2 * Math.PI * i / numPoints + Math.PI / numPoints - Math.PI / 2;

            // Внешняя точка
            points[i * 4] = (int) (centerX + radius * Math.cos(outerAngle));
            points[i * 4 + 1] = (int) (centerY + radius * Math.sin(outerAngle));

            // Внутренняя точка
            points[i * 4 + 2] = (int) (centerX + innerRadius * Math.cos(innerAngle));
            points[i * 4 + 3] = (int) (centerY + innerRadius * Math.sin(innerAngle));
        }

        // Рисуем заполненную звезду
        gc.setBackground(color);
        gc.fillPolygon(points);
        gc.drawPolygon(points);
    }
}
