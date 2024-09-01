package chapters.eight.shapes;

import static net.midview.Print.print;

public class Square extends Shape {

    public Square(int i) {
        super(i);
        print("Drawing Square");
    }

    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }

    @Override
    public void printBaseInfo() {
        System.out.println("Я реализация метода printBaseInfo() класса Square");
    }
}
