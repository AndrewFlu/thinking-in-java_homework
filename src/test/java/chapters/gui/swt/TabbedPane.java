package chapters.gui.swt;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Размещение компонентов SWT на вкладках
 */
public class TabbedPane implements SWTApplication {

    private static TabFolder tabFolder;
    private static Shell shell;

    private static final Listener listener = new Listener() {
        @Override
        public void handleEvent(Event event) {
            MessageBox m = new MessageBox(shell, SWT.OK);
            m.setMessage(event.toString());
            m.open();
        }
    };


    @Override
    public void createContents(Composite parent) {
        shell = parent.getShell();
        parent.setLayout(new FillLayout());
        tabFolder = new TabFolder(shell, SWT.BORDER);
        labelTab();
        directoryDialogTab();
        buttonTab();
        sliderTab();
        scribbleTab();
        browserTab();
    }

    private void labelTab() {
        TabItem tab = new TabItem(tabFolder, SWT.CLOSE);
        tab.setText("A Tab"); // Text on the tab
        tab.setToolTipText("Tab Tooltip Text");

        Label label = new Label(tabFolder, SWT.CENTER);
        label.setText("Label Text");

        tab.setControl(label);
    }

    private void directoryDialogTab() {
        TabItem tab = new TabItem(tabFolder, SWT.CLOSE);
        tab.setText("Directory Dialog");
        tab.setToolTipText("ToolTip: Select a Directory");
        final Button b = new Button(tabFolder, SWT.PUSH);
        b.setText("Select a Directory");
        b.addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event event) {
                DirectoryDialog dd = new DirectoryDialog(shell);
                String path = dd.open();
                if (path != null)
                    b.setText(path);
            }
        });
        tab.setControl(b);
    }

    private void buttonTab() {
        TabItem tab = new TabItem(tabFolder, SWT.CLOSE);
        tab.setText("Buttons");
        tab.setToolTipText("Different kinds of Buttons");

        Composite composite = new Composite(tabFolder, SWT.NONE);
        composite.setLayout(new GridLayout(4, true));
        for (int dir : new int[]{SWT.UP, SWT.RIGHT, SWT.LEFT, SWT.DOWN}) {
            Button b = new Button(composite, SWT.ARROW | dir);
            b.addListener(SWT.MouseDown, listener);
        }

        newButton(composite, SWT.CHECK, "Check Button");
        newButton(composite, SWT.PUSH, "Push Button");
        newButton(composite, SWT.RADIO, "Radio Button");
        newButton(composite, SWT.TOGGLE, "Toggle Button");
        newButton(composite, SWT.FLAT, "Flat Button");

        tab.setControl(composite);
    }

    private void newButton(Composite composite, int type, String label) {
        Button b = new Button(composite, type);
        b.setText(label);
        b.addListener(SWT.MouseDown, listener);
    }

    private void sliderTab() {
        TabItem tab = new TabItem(tabFolder, SWT.CLOSE);
        tab.setText("Sliders and Progress bars");
        tab.setToolTipText("Tied Slider to ProgressBar");

        Composite composite = new Composite(tabFolder, SWT.NONE);
        composite.setLayout(new GridLayout(2, true));

        final Slider slider = new Slider(composite, SWT.HORIZONTAL);
        final ProgressBar progressBar = new ProgressBar(composite, SWT.HORIZONTAL);

        slider.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                progressBar.setSelection(slider.getSelection());
            }
        });

        tab.setControl(composite);
    }

    private void scribbleTab() {
        TabItem tab = new TabItem(tabFolder, SWT.CLOSE);
        tab.setText("Scribble");
        tab.setToolTipText("Simple graphics: drawing");

        final Canvas canvas = new Canvas(tabFolder, SWT.NONE);
        ScribbleMouseListener sml = new ScribbleMouseListener();

        canvas.addMouseListener(sml);
        canvas.addMouseMoveListener(sml);

        tab.setControl(canvas);
    }

    private void browserTab() {
        TabItem tab = new TabItem(tabFolder, SWT.CLOSE);
        tab.setText("A Browser");
        tab.setToolTipText("A Web browser");

        Browser browser = null;
        try {
            browser = new Browser(tabFolder, SWT.NONE);
        } catch (SWTError e) {
            Label label = new Label(tabFolder, SWT.BORDER);
            label.setText("Could not initialize Browser");
            tab.setControl(label);
        }

        if (browser != null) {
            browser.setUrl("https://www.mindviewllc.com/");
            tab.setControl(browser);
        }
    }

    public static void main(String[] args) {
        SWTConsole.run(new TabbedPane(), 800, 600);
    }

    private static class ScribbleMouseListener extends MouseAdapter implements MouseMoveListener {


        private Point p = new Point(0, 0);

        @Override
        public void mouseMove(MouseEvent mouseEvent) {
            if ((mouseEvent.stateMask & SWT.BUTTON1) == 0)
                return;
            GC gc = new GC((Canvas) mouseEvent.widget);
            gc.drawLine(p.x, p.y, mouseEvent.x, mouseEvent.y);
            gc.dispose();
            updatePoint(mouseEvent);
        }

        @Override
        public void mouseDown(MouseEvent e) {
            updatePoint(e);
        }

        private void updatePoint(MouseEvent e) {
            p.x = e.x;
            p.y = e.y;
        }
    }
}
