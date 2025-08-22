package chapters.gui.swing.java_bean;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Frog {
    private int jumps;
    private Color color;
    private Spots spots;
    private boolean jmpr;

    public int getJumps() {
        return jumps;
    }

    public void setJumps(int newJumps) {
        this.jumps = newJumps;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public Spots getSpots() {
        return spots;
    }

    public void setSpots(Spots newSpots) {
        this.spots = newSpots;
    }

    public boolean isJmpr() {
        return jmpr;
    }

    public void setJmpr(boolean jmpr) {
        this.jmpr = jmpr;
    }

    public void addActionListener(ActionListener actionListener) {

    }

    public void removeActionListener(ActionListener actionListener) {

    }

    public void addKeyListener(KeyListener keyListener) {

    }

    public void removeKeyListener(KeyListener keyListener) {

    }

    // "обычный" открытый метод
    public void croak() {
        System.out.println("Ribbet!");
    }
}

class Spots {}
