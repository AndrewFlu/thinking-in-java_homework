package chapters.gui.swing.java_bean;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TooManyListenersException;

/**
 * Следует создавать компоненты Bean именно таким способом,
 * чтобы их можно было использовать в многозадачном окружении
 */
public class BangBean2 extends JPanel implements Serializable {

    private int xm, ym;
    // у слушателей должны быть возможность добавлять/удалять слушателей из списка.
    // А сам список нужен при использовании многоадресных событий вместо одноадресных как в версии BangBean
//    private ActionListener actionListener;
    private ArrayList<ActionListener> actionListeners = new ArrayList<>();

    private int circleSize = 20; // Диаметр окружности
    private String text = "Yass!!";
    private int fontSize = 48;
    private Color tColor = Color.RED;

    public BangBean2() {
        addMouseListener(new ML());
        addMouseMotionListener(new MML());
    }

    // getters - setters (как и все открытые методы) должны быть синхронизированными
    public synchronized int getCircleSize() {
        return circleSize;
    }

    public synchronized void setCircleSize(int newSize) {
        this.circleSize = newSize;
    }

    public synchronized int getFontSize() {
        return fontSize;
    }

    public synchronized void setFontSize(int newSize) {
        this.fontSize = newSize;
    }

    public synchronized Color getTextColor() {
        return tColor;
    }

    public synchronized void setTextColor(Color newColor) {
        this.tColor = newColor;
    }

    public synchronized String getBangText() {
        return text;
    }

    public synchronized void setBangText(String newText) {
        this.text = newText;
    }

    // methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawOval(xm - circleSize / 2, ym - circleSize / 2, circleSize, circleSize);
    }

    // Многоадресный слушатель — явление более типичное,
    // чем одноадресный подход, использованный в BangBean.java
    public synchronized void addActionListener(ActionListener l) {
        actionListeners.add(l);
    }

    public synchronized void removeActionListener(ActionListener l) {
        actionListeners.remove(l);
    }

//    public Dimension getPreferredSize() {
//        return new Dimension(200, 200);
//    }

    // Стоит обратить внимание: метод не объявлен synchronized:
    public void notifyListeners() {
        ActionEvent a = new ActionEvent(BangBean2.this, ActionEvent.ACTION_PERFORMED, null);
        ArrayList<ActionListener> lv = null;
        // Создаём поверхностную копию ArrayList
        // на тот случай, если слушатель будет добавлен в момент вызова:
        synchronized (this) {
            lv = new ArrayList<>(actionListeners);
        }
        // Вызов методов всех слушателей:
        for (ActionListener al : lv)
            al.actionPerformed(a);
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
            // Вызов метода слушателей
            notifyListeners();
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


    // test-drive
    public static void main(String[] args) {
        BangBean2 bb2 = new BangBean2();
        bb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent " + e);
            }
        });
        bb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("BangBean2 action");
            }
        });
        bb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("More action");
            }
        });

        JFrame frame = new JFrame();
        frame.add(bb2);

        SwingConsole.run(frame, 300, 300);
    }
}
