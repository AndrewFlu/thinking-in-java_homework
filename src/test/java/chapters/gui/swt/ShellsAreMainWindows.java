package chapters.gui.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ShellsAreMainWindows {
    static Shell[] shells = new Shell[10];

    public static void main(String[] args) {
        Display display = new Display();
        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell(display);
            shells[i].setText("Shell #" + i);
            shells[i].open();
        }
        while(!shellIsDisposed())
            if (!display.readAndDispatch())
                display.sleep();
        display.dispose();
    }

    private static boolean shellIsDisposed() {
        for (int i = 0; i < shells.length; i++) {
            if (shells[i].isDisposed())
                return true;
        }
        return false;
    }
}
