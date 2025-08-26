package chapters.gui.tasks.task_43;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class CheckBoxesSWT implements SWTApplication {
    private Shell shell;
    private Text textArea;

    private Button
            checkBox1,
            checkBox2,
            checkBox3;

    @Override
    public void createContents(Composite parent) {
        shell = parent.getShell();
        shell.setLayout(new GridLayout(1, true));

        textArea = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
        textArea.setBounds(20, 10, 350, 200);
        textArea.setText("Состояние чекбоксов \n\n");

        checkBox1 = new Button(shell, SWT.CHECK);
        checkBox1.setText("Чекбокс 1");
        checkBox2 = new Button(shell, SWT.CHECK);
        checkBox2.setText("Чекбокс 2");
        checkBox3 = new Button(shell, SWT.CHECK);
        checkBox3.setText("Чекбокс 3");

        checkBox1.addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event event) {
                trace("1", checkBox1);
            }
        });
        checkBox2.addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event event) {
                trace("2", checkBox2);
            }
        });
        checkBox3.addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event event) {
                trace("3", checkBox3);
            }
        });

    }

    private void trace(String boxName, Button checkBox) {
        if (!checkBox.getSelection())
            textArea.append("Box " + boxName + " Set\n");
        else
            textArea.append("Box " + boxName + " Cleared\n");
    }

    public static void main(String[] args) {
        SWTConsole.run(new CheckBoxesSWT(), 550, 350);
    }

}
