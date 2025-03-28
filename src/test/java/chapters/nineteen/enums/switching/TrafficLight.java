package chapters.nineteen.enums.switching;

import static chapters.nineteen.enums.switching.Signal.*;

public class TrafficLight {
    Signal color = RED;
    public void change() {
        switch (color) {
            // в секции case не обязательно использовать запись Signal.RED:
            case RED -> color = GREEN;
            case GREEN -> color = YELLOW;
            case  YELLOW -> color = RED;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(tl);
            tl.change();
        }
    }
}
