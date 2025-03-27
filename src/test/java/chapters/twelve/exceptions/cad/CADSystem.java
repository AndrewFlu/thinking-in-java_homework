package chapters.twelve.exceptions.cad;

import static net.mindview.utils.Print.print;

public class CADSystem extends Shape {

    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++)
            lines[j] = new Line(j, j * j);
        c = new Circle(1);
        t = new Triangle(1);
        print("Combined constructor");
    }

    @Override
    public void draw() throws IllegalArgumentException {
        t.draw();
        c.draw();
        for (int i = 0; i < lines.length; i++) {
            lines[i].draw();
        }
    }

    public void dispose() {
        print("CADSystem.dispose()");
        // The order of cleanup is the reverse
        // of the order of initialization:
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0; i--)
            lines[i].dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {
            // Code and exception handling...
            x.draw();
        } finally {
            x.dispose();
        }
    }
} /* Output:
Shape constructor
Shape constructor
Drawing Line: 0, 0
Shape constructor
Drawing Line: 1, 1
Shape constructor
Drawing Line: 2, 4
Shape constructor
Drawing Circle
Shape constructor
Drawing Triangle
Combined constructor
CADSystem.dispose()
Erasing Triangle
Shape dispose
Erasing Circle
Shape dispose
Erasing Line: 2, 4
Shape dispose
Erasing Line: 1, 1
Shape dispose
Erasing Line: 0, 0
Shape dispose
Shape dispose
*///:~
