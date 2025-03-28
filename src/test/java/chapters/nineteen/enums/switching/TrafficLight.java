package chapters.nineteen.enums.switching;

public class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            // в секции case не обязательно использовать запись Signal.RED:
            case RED -> color = Signal.GREEN;
            case GREEN -> color = Signal.YELLOW;
            case  YELLOW -> color = Signal.RED;
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
