package chapters.gui.tasks.task_22;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class RGBAdjustment extends JFrame {

    public static final int DEFAULT_RED_VALUE = 0;
    public static final int DEFAULT_GREEN_VALUE = 255;
    public static final int DEFAULT_BLUE_VALUE = 0;

    private JTextField redValue = new JTextField(String.valueOf(DEFAULT_RED_VALUE), 15);
    private JTextField greenValue = new JTextField(String.valueOf(DEFAULT_GREEN_VALUE), 15);
    private JTextField blueValue = new JTextField(String.valueOf(DEFAULT_BLUE_VALUE), 15);

    private JSlider redSlider = new JSlider(DEFAULT_RED_VALUE, 255, DEFAULT_RED_VALUE);
    private JSlider greenSlider = new JSlider(DEFAULT_RED_VALUE, 255, DEFAULT_GREEN_VALUE);
    private JSlider blueSlider = new JSlider(DEFAULT_RED_VALUE, 255, DEFAULT_BLUE_VALUE);

    private JPanel panel = new JPanel();

    public RGBAdjustment() throws HeadlessException {
        JPanel adjustingPanel = new JPanel();
        adjustingPanel.setLayout(new GridLayout(3, 2));
        // red
        JLabel redLabel = new JLabel("Red Color:");
        redLabel.setLabelFor(redValue);
        redValue.setEditable(false);
        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                int r = sliderValue;
                int g = Integer.parseInt(greenValue.getText());
                int b = Integer.parseInt(blueValue.getText());

                redValue.setText(String.valueOf(sliderValue));
                panel.setBackground(new Color(r, g, b));
            }
        });

        adjustingPanel.add(redLabel);
        adjustingPanel.add(redValue);
        adjustingPanel.add(redSlider);
        // green
        JLabel greenLabel = new JLabel("Green Color:");
        greenLabel.setLabelFor(greenValue);
        greenValue.setEditable(false);
        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                int r = Integer.parseInt(redValue.getText());
                int g = sliderValue;
                int b = Integer.parseInt(blueValue.getText());

                greenValue.setText(String.valueOf(sliderValue));
                panel.setBackground(new Color(r, g, b));
            }
        });

        adjustingPanel.add(greenLabel);
        adjustingPanel.add(greenValue);
        adjustingPanel.add(greenSlider);

        // blue
        JLabel blueLabel = new JLabel("Blue Color:");
        blueLabel.setLabelFor(blueValue);
        blueValue.setEditable(false);
        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                int r = Integer.parseInt(redValue.getText());
                int g = Integer.parseInt(greenValue.getText());
                int b = sliderValue;

                blueValue.setText(String.valueOf(sliderValue));
                panel.setBackground(new Color(r, g, b));
            }
        });

        adjustingPanel.add(blueLabel);
        adjustingPanel.add(blueValue);
        adjustingPanel.add(blueSlider);

        // panel
        add(BorderLayout.SOUTH, adjustingPanel);
        panel.setBackground(new Color(DEFAULT_RED_VALUE, DEFAULT_GREEN_VALUE, DEFAULT_BLUE_VALUE));
        add(BorderLayout.CENTER, panel);
    }

    public static void main(String[] args) {
        SwingConsole.run(new RGBAdjustment(), 550, 550);
    }
}
