package chapters.gui.tasks.task_32;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ProgressWithListener extends JFrame {

    private JProgressBar progressBar = new JProgressBar();
    private ProgressMonitor progressMonitor = new ProgressMonitor(
            this, "Monitoring Progress", "Test", 0, 100
    );
    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);

    public ProgressWithListener() throws HeadlessException {
        setLayout(new GridLayout(2, 1));
        progressBar.setBorder(new TitledBorder("Progress Bar"));
        add(progressBar);

        progressMonitor.setProgress(0);
        progressMonitor.setMillisToPopup(1_000);

        slider.setValue(0);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setBorder(new TitledBorder("Slide me"));

        add(slider);

        slider.addChangeListener(event -> {
            int sliderValue = slider.getValue();
            progressMonitor.setProgress(sliderValue);
            progressBar.setValue(sliderValue);
        });
    }

    public static void main(String[] args) {
        SwingConsole.run(new ProgressWithListener(), 550, 250);
    }
}
