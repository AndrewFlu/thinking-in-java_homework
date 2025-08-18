package chapters.gui.tasks.task_24;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class SketchDraw24 extends JFrame {

    private JButton clearButton = new JButton("Clear Screen");
    private JSlider verticalSlider = new JSlider(JSlider.VERTICAL);
    private JSlider horizontalSlider = new JSlider();
    SketchPanel sketchPanel = new SketchPanel();

    public SketchDraw24() throws HeadlessException {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sketchPanel.listOfPoints.clear();
                sketchPanel.clearPanel();
            }
        });
        verticalSlider.setInverted(true);
        verticalSlider.setValue(0);
        verticalSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int x = horizontalSlider.getValue();
                int y = verticalSlider.getValue();
                sketchPanel.horizontalOrVerticalMoved = true;
                sketchPanel.addSimplePoint(x, y);
            }
        });
        horizontalSlider.setValue(0);
        horizontalSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int x = horizontalSlider.getValue();
                int y = verticalSlider.getValue();
                sketchPanel.horizontalOrVerticalMoved = false;
                sketchPanel.addSimplePoint(x, y);
            }
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                horizontalSlider.setMaximum(sketchPanel.getWidth());
                verticalSlider.setMaximum(sketchPanel.getHeight());
            }
        });
        add(BorderLayout.NORTH, clearButton);
        add(BorderLayout.WEST, verticalSlider);
        add(BorderLayout.SOUTH, horizontalSlider);
        sketchPanel.setBackground(new Color(0xAFFFF));
        add(sketchPanel);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SketchDraw24(), 450, 450);
    }

    private class SketchPanel extends JPanel {
        public boolean horizontalOrVerticalMoved = false;

        java.util.List<SimplePoint> listOfPoints = new ArrayList<>();
        SimplePoint startingPoint;

        public void clearPanel() {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (horizontalOrVerticalMoved)
                g.setColor(Color.BLUE);
            else
                g.setColor(Color.RED);
            startingPoint = null;
            for (SimplePoint sp : listOfPoints)
                drawPoint(g, sp);
        }

        private void drawPoint(Graphics g, SimplePoint p) {
            if (startingPoint == null) {
                startingPoint = p;
                return;
            }
            g.drawLine(startingPoint.x, startingPoint.y, p.x, p.y);
            startingPoint = p;
        }

        public void addSimplePoint(int x, int y) {
            listOfPoints.add(new SimplePoint(x, y));
            repaint();
        }

        private class SimplePoint {
            int x;
            int y;

            public SimplePoint(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
