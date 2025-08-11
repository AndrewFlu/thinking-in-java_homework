package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class Buttons extends JFrame {

    private JButton jb = new JButton("JButton");
    private BasicArrowButton
            up = new BasicArrowButton(BasicArrowButton.NORTH),
            down = new BasicArrowButton(BasicArrowButton.SOUTH),
            left = new BasicArrowButton(BasicArrowButton.WEST),
            right = new BasicArrowButton(BasicArrowButton.EAST);

    public Buttons() throws HeadlessException {
        setLayout(new FlowLayout());
        add(jb);
        add(new JToggleButton("JToggleButton"));
        add(new JCheckBox("JCheckBox"));
        add(new JRadioButton("JRadioButton"));

        // arrows
        JPanel jp = new JPanel();
        jp.setBorder(new TitledBorder("Directions"));
        jp.add(up);
        jp.add(down);
        jp.add(left);
        jp.add(right);
        add(jp);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Buttons(), 150, 350);
    }
}
