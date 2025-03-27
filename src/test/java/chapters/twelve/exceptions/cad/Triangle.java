package chapters.twelve.exceptions.cad;

import static net.mindview.utils.Print.print;

public class Triangle extends Shape {

    public Triangle(int i) {
        super(i);
        print("Drawing Triangle");
    }

    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }

    @Override
    public void printBaseInfo() {
        System.out.println("Я реализация метода printBaseInfo() класса Triangle");
    }
}
