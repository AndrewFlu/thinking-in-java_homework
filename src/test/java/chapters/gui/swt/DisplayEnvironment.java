package chapters.gui.swt;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import java.util.Map;

public class DisplayEnvironment  implements SWTApplication {
    @Override
    public void createContents(Composite parent) {
        parent.setLayout(new FillLayout());
        Text text = new Text(parent, SWT.WRAP | SWT.V_SCROLL);
        for (Map.Entry<String, String> entry : System.getenv().entrySet()){
            text.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SWTConsole.run(new DisplayEnvironment(), 750, 550);
    }
}
