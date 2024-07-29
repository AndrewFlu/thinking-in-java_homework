package chapters.eight.shapes;

public class Shape {
    public void draw(){}

    public void erase(){}

    public void printInfo() {
        System.out.println("Я экзлемпляр класса " + getClass().getSimpleName());
    }

    public void printBaseInfo() {
        System.out.println("Я реализация метода printBaseInfo() базового класса");
    }
}
