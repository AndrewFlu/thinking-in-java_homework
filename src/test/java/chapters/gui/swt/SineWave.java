package chapters.gui.swt;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Slider;

public class SineWave implements SWTApplication {

    private static final int MIN_CYCLES_VALUE = 1;

    private SineDraw sines;
    private Slider slider;


    @Override
    public void createContents(Composite parent) {
        parent.setLayout(new GridLayout(1, true));

        sines = new SineDraw(parent, SWT.NONE);
        sines.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        sines.setFocus();

        slider = new Slider(parent, SWT.HORIZONTAL);
        slider.setMinimum(MIN_CYCLES_VALUE);
        slider.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false));
        slider.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                sines.setCycles(slider.getSelection());
            }
        });
    }

    public static void main(String[] args) {
        SWTConsole.run(new SineWave(), 700, 400);
    }
}

class SineDraw extends Canvas {

    private static final int SCALE_FACTOR = 200;

    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    public SineDraw(Composite parent, int style) {
        super(parent, style);
        addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent paintEvent) {
                int maxWidth = getSize().x;
                double hStep = (double) maxWidth / (double) points;

                int maxHeight = getSize().y;
                pts = new int[points];

                for (int i = 0; i < points; i++) {
                    pts[i] = (int) ((sines[i] * maxHeight / 2 * .95) + (maxHeight / 2));
                }

                paintEvent.gc.setForeground(paintEvent.display.getSystemColor(SWT.COLOR_RED));

                for (int i = 1; i < points; i++) {
                    int x1 = (int) ((i - 1) * hStep);
                    int x2 = (int) (i * hStep);
                    int y1 = pts[i - 1];
                    int y2 = pts[i];

                    paintEvent.gc.drawLine(x1, y1, x2, y2);
                }
            }
        });
        setCycles(5);
    }

    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALE_FACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALE_FACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        redraw();
    }


}
