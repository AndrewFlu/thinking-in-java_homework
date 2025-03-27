package chapters.eight.shapes;

import static net.mindview.utils.Print.print;

public class Shape {
    public Shape(int i) {
        print("Shape constructor");
    }

    public void draw(){}

    public void erase(){}

    public void printInfo() {
        System.out.println("Я экзлемпляр класса " + getClass().getSimpleName());
    }

    public void printBaseInfo() {
        System.out.println("Я реализация метода printBaseInfo() базового класса");
    }

    public void dispose() { print("Shape dispose"); }
}
