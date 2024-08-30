package chapters.eleven.containers.iterators.shapes;

public class Circle extends Shape {
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
