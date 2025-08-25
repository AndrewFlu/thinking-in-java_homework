package chapters.gui.tasks.task_41;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.Map;

public class DisplayEnvironment_41 {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        shell.setText("Display Environment");
        shell.setSize(850, 550);

        Text text = new Text(shell, SWT.WRAP | SWT.V_SCROLL);
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            text.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        shell.open();

        while (!shell.isDisposed())
            if (!display.readAndDispatch())
                display.sleep();
        display.dispose();
    }
}
