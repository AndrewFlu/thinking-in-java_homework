package chapters.gui.tasks.task_40;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import java.io.PrintWriter;
import java.io.StringWriter;

public class DisplayProperties_40 implements SWTApplication {
    public static void main(String[] args) {
        SWTConsole.run(new DisplayProperties_40(), 850, 950);
    }

    @Override
    public void createContents(Composite parent) {
        parent.setLayout(new FillLayout());

        Text text = new Text(parent, SWT.WRAP | SWT.V_SCROLL);
        StringWriter props = new StringWriter();
        System.getProperties().list(new PrintWriter(props));
        text.setText(props.toString());
    }
}
