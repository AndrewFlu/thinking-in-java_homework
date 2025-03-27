package chapters.eight.shapes;

import static net.mindview.utils.Print.print;

public class Circle extends Shape{

    public Circle(int i) {
        super(i);
        print("Drawing Circle");
    }

    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase(){
        System.out.println("Circle.erase()");
    }

    @Override
    public void printBaseInfo() {
        System.out.println("Я реализация метода printBaseInfo() класса Circle");
    }
}
