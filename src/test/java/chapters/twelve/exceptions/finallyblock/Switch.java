package chapters.twelve.exceptions.finallyblock;

import static net.mindview.utils.Print.print;

public class Switch {
    private boolean state = false;

    private boolean read() {
        return state;
    }
    public void on() {
        state = true;
        print(this.toString());
    }

    public void off() {
        state = false;
        print(this.toString());
    }

    @Override
    public String toString() {
        return state ? "Вкл" : "Выкл";
    }
}
