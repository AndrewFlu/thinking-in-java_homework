package chapters.gui.swt.parallel;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import chapters.twenty_one.concurrency.daemons.DaemonThreadPoolExecutor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ColorBoxes implements SWTApplication {

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
        ColorBoxes colorBoxes = new ColorBoxes();
        SWTConsole.run(colorBoxes, 550, 450);
    }
}

class CBox extends Canvas implements Runnable {

    private static Random random = new Random();

    private RGB cColor = newColor();
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
            Color color = new Color(paintEvent.display, cColor);
            paintEvent.gc.setBackground(color);
            Point size = getSize();
            paintEvent.gc.fillRectangle(0, 0, size.x, size.y);
            color.dispose();
        }
    }
}
