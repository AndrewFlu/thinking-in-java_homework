package chapters.gui.swt;

import chapters.gui.swt.util.SWTApplication;
import chapters.gui.swt.util.SWTConsole;
import net.mindview.utils.TextFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Развлечения с меню
 * Читает свой исходный код, разбивает его на слова, после чего заполняет меню этими словами
 */
public class Menus implements SWTApplication {

    private static Shell shell;
    private final Listener listener = new Listener() {

        @Override
        public void handleEvent(Event event) {
            System.out.println(event.toString());
        }
    };

    @Override
    public void createContents(Composite parent) {
        shell = parent.getShell();

        Menu bar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(bar);
        Set<String> words = new TreeSet<>(
                new TextFile("src/test/java/chapters/gui/swt/Menus.java", "\\W+")
        );
        Iterator<String> iterator = words.iterator();
        while (iterator.next().matches("[0-9]+"))
            ; // числа пропускаются
        MenuItem[] mItem = new MenuItem[7];
        for (int i = 0; i < mItem.length; i++) {
            mItem[i] = new MenuItem(bar, SWT.CASCADE);
            mItem[i].setText(iterator.next());
            Menu subMenu = new Menu(shell, SWT.DROP_DOWN);
            mItem[i].setMenu(subMenu);
        }

        int i = 0;
        while (iterator.hasNext()) {
            addItem(bar, iterator, mItem[i]);
            i = (i + 1) % mItem.length;
        }
    }

    private void addItem(Menu bar, Iterator<String> iterator, MenuItem menuItem) {
        MenuItem item = new MenuItem(menuItem.getMenu(), SWT.PUSH);
        item.addListener(SWT.Selection, listener);
        item.setText(iterator.next());
    }


    public static void main(String[] args) {
        SWTConsole.run(new Menus(), 550, 350);
    }
}
