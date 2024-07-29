package chapters.eight.shapes;

public class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase(){
        System.out.println("Square.erase()");
    }

    @Override
    public void printBaseInfo() {
        System.out.println("Я реализация метода printBaseInfo() класса Square");
    }
}
