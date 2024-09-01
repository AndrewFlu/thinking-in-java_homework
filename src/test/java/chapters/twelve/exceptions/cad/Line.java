package chapters.twelve.exceptions.cad;

import chapters.eight.shapes.Shape;

import static net.midview.Print.print;

public class Line extends Shape {
    private int start, end;
    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line: " + start + ", " + end);
    }

    public void dispose() {
        print("Erasing Line: " + start + ", " + end);
        super.dispose();
    }
}
