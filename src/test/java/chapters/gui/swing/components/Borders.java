package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Borders extends JFrame {

    static JPanel showBorder(Border border) {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        String borderName = border.getClass().toString();
        borderName = borderName.substring(borderName.lastIndexOf(".") + 1);
        jp.add(new JLabel(borderName, JLabel.CENTER), BorderLayout.CENTER);
        jp.setBorder(border);

        return jp;
    }

    public Borders() throws HeadlessException {
        setLayout(new GridLayout(2, 4));
        add(showBorder(new TitledBorder("Title")));
        add(showBorder(new EtchedBorder()));
        add(showBorder(new LineBorder(Color.BLUE)));
        add(showBorder(new MatteBorder(5, 5, 30, 30, Color.GREEN))); // матовая граница с заданной заливкой
        add(showBorder(new BevelBorder(BevelBorder.RAISED))); // скошенная граница (приподнятая)
        add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED))); // скошенная граница (утопленная)
        add(showBorder(new CompoundBorder(
                new EtchedBorder(), // outside border
                new LineBorder(Color.RED) // inside border
        )));
    }

    public static void main(String[] args) {
        SwingConsole.run(new Borders(), 900, 500);
    }
}
