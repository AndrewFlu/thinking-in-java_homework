package chapters.gui.swing.java_bean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.TooManyListenersException;

/**
 * Графический компонент Bean
 */
public class BangBean extends JPanel implements Serializable {

    private int xm, ym;
    private ActionListener actionListener;

    private int circleSize = 20; // Диаметр окружности
    private String text = "Yass!!";
    private int fontSize = 48;
    private Color tColor = Color.RED;

    public BangBean() {
        addMouseListener(new ML());
        addMouseMotionListener(new MML());
    }

    // getters - setters
    public int getCircleSize() {
        return circleSize;
    }

    public void setCircleSize(int newSize) {
        this.circleSize = newSize;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int newSize) {
        this.fontSize = newSize;
    }

    public Color getTextColor() {
        return tColor;
    }

    public void setTextColor(Color newColor) {
        this.tColor = newColor;
    }

    public String getBangText() {
        return text;
    }

    public void setBangText(String newText) {
        this.text = newText;
    }

    // methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawOval(xm - circleSize / 2, ym - circleSize / 2, circleSize, circleSize);
    }

    // Одноадресный слушатель, простейшая форма управления слушателями:
    public void addActionListener(ActionListener l) throws TooManyListenersException {
        if (actionListener != null)
            throw new TooManyListenersException();
        actionListener = l;
    }

    public void removeActionListener(ActionListener l) {
        actionListener = null;
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    // inner classes
    private class ML extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Graphics graphics = getGraphics();
            graphics.setColor(tColor);
            graphics.setFont(
                    new Font("Verdana", Font.ITALIC, fontSize)
            );
            int width = graphics.getFontMetrics().stringWidth(text);
            graphics.drawString(text, (getSize().width - width) / 2, getSize().height / 2);
            graphics.dispose();
            // Вызов метода слушателя
            if (actionListener != null)
                actionListener.actionPerformed(
                        new ActionEvent(BangBean.this, ActionEvent.ACTION_PERFORMED, null)
                );
        }
    }

    public class MML extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            xm = e.getX();
            ym = e.getY();
            repaint();
        }
    }

}
