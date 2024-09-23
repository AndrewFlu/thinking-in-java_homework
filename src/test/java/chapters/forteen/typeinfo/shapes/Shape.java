package chapters.forteen.typeinfo.shapes;

public abstract class Shape {
    protected boolean isActive;

    void draw() {
        System.out.println(this + ".draw()");
    }

    void setActive() {
        isActive = true;
    }

    public abstract String toString();
}
