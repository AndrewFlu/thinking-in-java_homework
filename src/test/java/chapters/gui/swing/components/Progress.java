package chapters.gui.swing.components;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Progress extends JFrame {

    private JProgressBar progressBar = new JProgressBar();
    private ProgressMonitor progressMonitor = new ProgressMonitor(
            this, "Monitoring Progress", "Test", 0, 100
    );
    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);

    public Progress() throws HeadlessException {
        setLayout(new GridLayout(2, 1));
        progressBar.setModel(slider.getModel()); // чтобы задать одинаковое поведение и у слайдера, и у прогресс-бара
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

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                progressMonitor.setProgress(slider.getValue());
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.run(new Progress(), 550, 250);
    }
}
