package chapters.eight.shapes;

import static net.mindview.utils.Print.print;

public class Octagon extends Shape {
    public Octagon(int i) {
        super(i);
        print("Drawing Octagon");
    }

    @Override
    public void draw() {
        System.out.println("Octagon.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Octagon.erase()");
    }
}
