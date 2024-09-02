package chapters.twelve.exceptions.cad;

import static net.midview.Print.print;

public abstract class Shape {

    public static final int MAX_INT = 30;

    public Shape(int i) {
        print("Shape constructor");
    }

    public abstract void draw() throws IllegalArgumentException;

    public void erase(){}

    public void printInfo() {
        System.out.println("Я экзлемпляр класса " + getClass().getSimpleName());
    }

    public void printBaseInfo() {
        System.out.println("Я реализация метода printBaseInfo() базового класса");
    }

    public void dispose() { print("Shape dispose"); }
}
