package chapters.gui.tasks.task_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class TrackEvent_12 extends JFrame {
    private HashMap<String, JTextField> inputsMap = new HashMap();
    private String[] event = {
            "focusGained", "focusLost", "keyPressed",
            "keyReleased", "keyTyped", "mouseClicked",
            "mouseEntered", "mouseExited", "mousePressed",
            "mouseReleased", "mouseDragged", "mouseMoved",
            "itemStateChanged",
            "windowOpened", "windowClosing", "windowClosed",
            "windowIconified", "windowDeiconified",
            "windowActivated", "windowDeactivated"
    };

    private MyButton
            b1 = new MyButton(Color.BLUE, "test1"),
            b2 = new MyButton(Color.RED, "test2");
    private JButton resetButton = new JButton("Reset");

    class MyButton extends JButton {
        void report(String eventName, String msg) {
            inputsMap.get(eventName).setText(msg);
        }

        FocusListener fl = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                report("focusGained", e.paramString());
            }

            @Override
            public void focusLost(FocusEvent e) {
                report("focusLost", e.paramString());
            }
        };
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                report("keyTyped", e.paramString());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                report("keyPressed", e.paramString());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                report("keyReleased", e.paramString());
            }
        };
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                report("mouseClicked", e.paramString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                report("mousePressed", e.paramString());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                report("mouseReleased", e.paramString());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                report("mouseEntered", e.paramString());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                report("mouseExited", e.paramString());
            }
        };
        MouseMotionListener mml = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                report("mouseDragged", e.paramString());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                report("mouseMoved", e.paramString());
            }
        };

        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                report("itemStateChanged", e.paramString());
            }
        };
        WindowListener wl = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                report("windowOpened", e.paramString());
            }

            @Override
            public void windowClosing(WindowEvent e) {
                report("windowClosing", e.paramString());
            }

            @Override
            public void windowClosed(WindowEvent e) {
                report("windowClosed", e.paramString());
            }

            @Override
            public void windowIconified(WindowEvent e) {
                report("windowIconified", e.paramString());
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                report("windowDeiconified", e.paramString());
            }

            @Override
            public void windowActivated(WindowEvent e) {
                report("windowActivated", e.paramString());
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                report("windowDeactivated", e.paramString());
            }
        };

        public MyButton(Color color, String label) {
            super(label);
            setBackground(color);
            addFocusListener(fl);
            addKeyListener(kl);
            addMouseListener(ml);
            addMouseMotionListener(mml);
            addItemListener(il);
            addWindowListener(wl);
        }
    }

    public TrackEvent_12() {
        // center content
        JPanel centerContent = new JPanel(new GridLayout(event.length + 1, 2));

        for (String evt : event) {
            JTextField t = new JTextField();
            t.setEditable(false);
            centerContent.add(new JLabel(evt, JLabel.RIGHT));
            centerContent.add(t);
            inputsMap.put(evt, t);
        }
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry<String, JTextField> entry : inputsMap.entrySet()) {
                    var field = entry.getValue();
                    field.setText("");
                }
            }
        });
        centerContent.add(b1);
        centerContent.add(b2);

        // bottom content
        JPanel bottomContent = new JPanel(new BorderLayout());
        bottomContent.add(BorderLayout.CENTER, resetButton);

        add(BorderLayout.CENTER, centerContent);
        add(BorderLayout.SOUTH, bottomContent);
    }

    public static void main(String[] args) {
        TrackEvent_12 form = new TrackEvent_12();
        form.setTitle(form.getClass().getSimpleName());
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setSize(1500, 500);
        form.setVisible(true);
    }
}
