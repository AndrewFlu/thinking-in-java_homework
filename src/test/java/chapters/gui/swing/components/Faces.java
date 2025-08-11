package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Поведение значков в кнопках JButton
 */
public class Faces extends JFrame {

    private static Icon[] faces;
    private JButton jb, jb2 = new JButton("Disable");
    private boolean mad = false;

    public Faces() throws HeadlessException {
        faces = new Icon[]{
                new ImageIcon("Face0.gif"),
                new ImageIcon("Face1.gif"),
                new ImageIcon("Face2.gif"),
                new ImageIcon("Face3.gif"),
                new ImageIcon("Face4.gif"),
        };
        jb = new JButton("Jbutton", faces[3]);
        setLayout(new FlowLayout());
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mad) {
                    jb.setIcon(faces[3]);
                    mad = false;
                } else {
                    jb.setIcon(faces[0]);
                    mad = true;
                }
                jb.setVerticalAlignment(JButton.TOP);
                jb.setHorizontalAlignment(JButton.LEFT);
            }
        });
        jb.setRolloverEnabled(true);
        jb.setRolloverIcon(faces[1]);
        jb.setPressedIcon(faces[2]);
        jb.setDisabledIcon(faces[4]);
        jb.setToolTipText("Tooltip text");
        add(jb);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jb.isEnabled()) {
                    jb.setEnabled(false);
                    jb.setText("Enable");
                } else {
                    jb.setEnabled(true);
                    jb2.setText("Disable");
                }
            }
        });
        add(jb2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Faces(), 350, 125);
    }
}
