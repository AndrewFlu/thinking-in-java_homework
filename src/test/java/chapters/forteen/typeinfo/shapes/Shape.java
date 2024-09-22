package chapters.forteen.typeinfo.shapes;

public abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}
